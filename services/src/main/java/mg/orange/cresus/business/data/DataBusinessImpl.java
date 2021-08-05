package mg.orange.cresus.business.data;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import mg.orange.cresus.enumerator.DateFormat;
import mg.orange.cresus.domain_object.projection.PBase;
import mg.orange.cresus.repository.CbmDailyContractRepository;
import mg.orange.cresus.repository.CbmMonthlyUsageRepository;
import mg.orange.cresus.repository.MonthlyUsageRepository;
import mg.orange.cresus.utils.DateUtils;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import java.lang.reflect.ParameterizedType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataBusinessImpl<Data, Source, Projection extends PBase,
        LocalRepository extends PanacheMongoRepository<Data>,
        ExternalRepository extends PanacheMongoRepository<Source>>
        implements DataBusiness<Data, Source, Projection,
        LocalRepository, ExternalRepository> {

    @Inject
    ExternalRepository externalRepository;

    @Inject
    LocalRepository localRepository;

    @Override
    public void saveAll(List<Data> clients) {
        if(clients != null && !clients.isEmpty()) {
            this.localRepository.persist(clients);
        }
    }

    @Override
    public ObjectId getNextId(PanacheQuery<Projection> panacheQuery, int size) {
        Optional<Projection> optionalProjection = panacheQuery.page(Page.of(size - 1, 1)).firstResultOptional();
        return optionalProjection.isPresent() ? optionalProjection.get().id : null;
    }

    @Override
    public List<Projection> getList(PanacheQuery<Projection> panacheQuery, int size) {
        return panacheQuery.page(Page.ofSize(size)).list();
    }

    @Override
    public List<Projection> classicPagination(PanacheQuery<Projection> panacheQuery, Page page) {
        return panacheQuery.page(page).list();
    }

    @Override
    public PanacheQuery<Projection> keySetPagination(String[] fields, Sort.Direction direction, Date[] dates, ObjectId... id) {
        final Sort sort = this.getSort(fields, direction);
        final String operator = (this.isInAscendingOrder(direction)) ? ">" : "<";
        StringBuilder baseQuery = new StringBuilder("_id ")
                .append(operator).append(" ?1");
        PanacheQuery<Source> panacheQuery = null;

        if(dates != null && dates.length > 0 && dates[0] != null) {
            String queryDate = "";
            final Date yesterday = DateUtils.jump(dates[0], Calendar.DATE, -1);
            String strYesterday = castDateFormatToString(DateUtils.parsDate(yesterday, DateFormat.YYYYMMDD_DASH.getValue()));
            String dateFirst = castDateFormatToString(dates[0]);
            String dateSeconf = "";
            if(dates.length > 1)
                dateSeconf =  castDateFormatToString(dates[1]);

            if(id.length == 0 || id == null || id[0] == null) {
                // Update index
                if(dates.length == 1) {
                    queryDate = "day = ?1";
                    if(externalRepository instanceof CbmMonthlyUsageRepository){
//                        String dateFirst = castDateFormatToString(DateUtils.parsDate(yesterday, DateFormat.YYYYMMDD_DASH.getValue()));
                        panacheQuery = this.externalRepository.find(queryDate, sort,dateFirst);
                    } else {
                        panacheQuery = this.externalRepository.find(queryDate, sort,
                                DateUtils.parsDate(yesterday, DateFormat.YYYYMMDD_DASH.getValue()));
                    }

                } else {
                    queryDate = "day >= ?1 , day < ?2";
                    if(externalRepository instanceof CbmMonthlyUsageRepository){
//                        String dateFirst = castDateFormatTo jj                                                                                        String(dates[0]);
//                        String dateSeconf = castDateFormatToString(dates[1]);
                        panacheQuery = this.externalRepository.find(queryDate, sort
                                , dateFirst, dateSeconf);
                    } else {
                        panacheQuery = this.externalRepository.find(queryDate, sort, dates[0], dates[1]);
                    }


                }
            } else {
                if(dates.length == 1) {
                    queryDate = "day = ?2";
                    baseQuery.append(", ").append(queryDate);
                    if(externalRepository instanceof CbmMonthlyUsageRepository){
//                        String dateFirst = castDateFormatToString(DateUtils.parsDate(yesterday, DateFormat.YYYYMMDD_DASH.getValue()));
                        panacheQuery = this.externalRepository.find(baseQuery.toString(), sort, id[0], dateFirst);
                    } else {
                        panacheQuery = this.externalRepository.find(baseQuery.toString(), sort, id[0],
                                DateUtils.parsDate(yesterday, DateFormat.YYYYMMDD_DASH.getValue()));
                    }

                } else {
                    queryDate = "day >= ?2 , day < ?3";
                    baseQuery.append(", ").append(queryDate);
                    if(externalRepository instanceof CbmMonthlyUsageRepository){
//                        String dateFirst = castDateFormatToString(dates[0]);
//                        String dateSeconf = castDateFormatToString(dates[1]);
                        panacheQuery = this.externalRepository.find(baseQuery.toString(), sort, id[0],
                                dateFirst, dateSeconf);
                    } else {
                        panacheQuery = this.externalRepository.find(baseQuery.toString(), sort, id[0], dates[0], dates[1]);
                    }
                }
            }
        } else {
            panacheQuery = (id.length > 0 && id[0] != null)
                    ? this.externalRepository.find(baseQuery.toString(), sort, id[0])
                    : this.externalRepository.findAll(sort);
        }
        
        return panacheQuery.project(
                (Class<Projection>) (
                        (ParameterizedType) this.getClass().getGenericSuperclass())
                        .getActualTypeArguments()[2]
        );
    }

    private String castDateFormatToString(Date date){

        Calendar calStartDate = Calendar.getInstance();
        calStartDate.setTime(date);
        String year =  String.valueOf(calStartDate.get(Calendar.YEAR));
        String month = String.valueOf(calStartDate.get(Calendar.MONTH) + 1);
        if(month.length() == 1)
            month = "0".concat(month);

        return year.concat(month);
    }

    @Override
    public long getCount(Date... dates) {
        long count = 0;

        if(dates != null && dates.length >= 1 ) {
            count = this.keySetPagination(new String[]{ "_id" }, Sort.Direction.Ascending, dates)
                    .page(Page.ofSize(1)).count();
        } else {
            count = this.externalRepository.count();
        }

        System.out.printf("Count %s\n", count);

        return count;
    }

    @Override
    public void deleteAll(Date... dates) {
        System.out.println("dates---->" + dates[0]);
        if(dates != null && dates.length > 0 ) {
            if(this.localRepository instanceof MonthlyUsageRepository){
                this.localRepository.delete("day", castDateFormatToString(dates[0]));
                System.out.println("DELETE Monthly Finished........");
            } else {
                this.localRepository.delete("day", dates[0]);
            }

        } else {
            this.localRepository.deleteAll();
        }
    }


    private Sort getSort(String[] fields, Sort.Direction direction) {
        return (this.isInAscendingOrder(direction))
                ? Sort.ascending(fields) : Sort.descending(fields);
    }

    private boolean isInAscendingOrder(Sort.Direction direction) {
        return direction == Sort.Direction.Ascending;
    }
}
