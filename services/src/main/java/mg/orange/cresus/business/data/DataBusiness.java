package mg.orange.cresus.business.data;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import mg.orange.cresus.domain_object.projection.PBase;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DataBusiness<Data, Source, Projection extends PBase,
        LocalRepository extends PanacheMongoRepository<Data>,
        ExternalRepository extends PanacheMongoRepository<Source>> {

    void saveAll(List<Data> clients);
    ObjectId getNextId(PanacheQuery<Projection> panacheQuery, int size);
    List<Projection> getList(PanacheQuery<Projection> panacheQuery,int size);
    List<Projection> classicPagination(PanacheQuery<Projection> panacheQuery, Page page);
    PanacheQuery<Projection> keySetPagination(String[] fields, Sort.Direction direction, Date[] dates, ObjectId... id);
    long getCount(Date... dates);
    void deleteAll(Date... dates);
}
