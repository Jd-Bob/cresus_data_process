package mg.orange.cresus.application.data;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheQuery;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import mg.orange.cresus.application.GlobalMapper;
import mg.orange.cresus.business.data.DataBusinessImpl;
import mg.orange.cresus.domain_object.projection.*;
import mg.orange.cresus.utils.DateTimeUtils;
import mg.orange.cresus.utils.DecimalUtils;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class DataApplicationImpl<Data, Source, Projection extends PBase,
        LocalRepository extends PanacheMongoRepository<Data>,
        ExternalRepository extends PanacheMongoRepository<Source>>
        extends DataBusinessImpl<Data, Source, Projection, LocalRepository,
        ExternalRepository> implements DataApplication<Data, Source, Projection,
        LocalRepository, ExternalRepository> {

    @Inject
    private GlobalMapper globalMapper;

    private static final int MAX_BLOCK_SIZE = 250;
    private static final int MAX_SIZE_PER_PAGE = 10_000;

    private String[] fields = { "_id" };

    @Override
    public void synchronization(Date... dates) {
        final long count = this.getCount(dates);

        this.parallelReading(count, dates);
    }

    @Override
    public void delete(Date... dates) {
        this.deleteAll(dates);
    }

    private void parallelReading(final double count, Date... dates) {
        final long start = System.nanoTime();
        final double countSplit = count / 2;
        final double totalHalfPages = countSplit / MAX_SIZE_PER_PAGE;
        final double remainingDataValue = DecimalUtils.getDecimalPart(totalHalfPages);

        final double blockCountCalc = (int)totalHalfPages / (double)MAX_BLOCK_SIZE;
        final int blockCount = (int)Math.ceil(blockCountCalc);
        final double remainingPageValue = DecimalUtils.getDecimalPart(blockCountCalc);
        final double[] remainingValues = { remainingPageValue, remainingDataValue };

        // Forward reading
        Uni<Boolean> forward = this.fetchForward(blockCount, remainingValues, true, dates);

        // Backward reading
        Uni<Boolean> backward = this.fetchForward(blockCount, remainingValues, false, dates);

        Uni.combine().all().unis(forward, backward).asTuple().subscribe().with(tuple -> {
            System.out.printf("Sync took %.1f min\n", DateTimeUtils.diffTime(start) / 60);
        });
    }

    private Uni<Boolean> fetchForward(final int blockCount, final double[] remainingValues, final boolean isForwardReading, Date... dates) {
        return Uni.createFrom().completionStage(CompletableFuture.supplyAsync(() -> {
            final Sort.Direction sort = (isForwardReading) ? Sort.Direction.Ascending
                    : Sort.Direction.Descending;
            int count = blockCount;
            int totalPage = MAX_BLOCK_SIZE;
            double remainingDecimalValue = 0.0;
            ObjectId lastId = null;

            while(count != 0) {
                // Update the remaining page size
                if((count - 1) == 0) {
                    double nbPages = getTotalPage(remainingValues[0]);
                    double remaining = DecimalUtils.getDecimalPart(nbPages);
                    totalPage = DecimalUtils.getUnitPart(nbPages) + 1;
                    remainingDecimalValue = remainingValues[1] + remaining;
                }

                // Track last id. Used to perform the next query using key set pagination
                lastId = this.retrieveData(
                        totalPage,
                        MAX_SIZE_PER_PAGE,
                        lastId,
                        dates,
                        sort,
                        remainingDecimalValue
                );

                // Get next _id
                /*lastId = nextId(lastId, totalPage, sort, dates);

                if(lastId == null) {
                    System.out.println("Next id not found or synchronizing is done");
                    break;
                }*/
                count--;
            }

            return true;
        }));
    }

    private ObjectId retrieveData(final int pages, final int size, ObjectId id, final Date[] dates, final Sort.Direction direction, final double remainingDataLeft) {
        int currentSize = MAX_SIZE_PER_PAGE;
        ObjectId lastId = id;

        try {
            for(int i = 0; i < pages; i++) {
                long startGetData = System.nanoTime();

                // Request
                PanacheQuery<Projection> panacheQuery = this.keySetPagination(fields, direction, dates, lastId);
                List<Projection> projections = this.getList(panacheQuery, currentSize);

                // Break the loop if no results are found
                if(projections == null || projections.isEmpty()) {
                    break;
                }

                // Track last id. Used to perform the next query using key set pagination
                lastId = projections.get(projections.size() - 1).id;

                // Save data
                this.saveData(projections);

                // Retrieve remaining data
                if(i + 1 == pages - 1) {
                    currentSize = this.getTotalSize(remainingDataLeft, (direction == Sort.Direction.Ascending));
                }

                System.out.printf("\nRetrieve data took [last _id: %s] = %.3f\n", lastId, DateTimeUtils.diffTime(startGetData));
            }
        } catch (Exception e) {
            System.out.println("Error while retrieving from _ID[" + lastId + "]");
            System.out.println(e.getMessage());
        }

        return lastId;
    }

    private void saveData(final List<Projection> pData) {
        final Class dataClass = (Class<Data>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        final String[] canonicalName = dataClass.getCanonicalName().split("\\.");
        final String dataClassName = (canonicalName.length > 0)
                ? canonicalName[canonicalName.length - 1]
                : canonicalName[0];

        this.saveAll(this.globalMapper.<Data, Projection>mapper(pData, dataClassName));
    }



    private ObjectId nextId(final ObjectId id, final int totalPage, final Sort.Direction sort, Date... dates) {
        PanacheQuery<Projection> panacheQuery = keySetPagination(this.fields, sort, dates, id);

        return getNextId(panacheQuery, totalPage * MAX_SIZE_PER_PAGE);
    }

    private double getTotalPage(double remainingPageValue) {
        double totalPage = MAX_BLOCK_SIZE;

        if(remainingPageValue > 0.0 && remainingPageValue < 1.0) {
            totalPage = remainingPageValue * (double)MAX_BLOCK_SIZE;
        }

        return totalPage;
    }

    private int getTotalSize(double decimalPart, boolean isForwardReading) {
        if(decimalPart > 0.0 && decimalPart < 1.0) {
            final double newSize = decimalPart * (double)MAX_SIZE_PER_PAGE;

            return (isForwardReading) ? (int)Math.ceil(newSize) : DecimalUtils.getUnitPart(newSize);
        }

        return  MAX_SIZE_PER_PAGE;
    }
}
