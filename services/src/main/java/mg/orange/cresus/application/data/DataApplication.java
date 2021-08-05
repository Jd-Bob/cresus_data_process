package mg.orange.cresus.application.data;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import mg.orange.cresus.domain_object.projection.PBase;

import java.util.Date;

public interface DataApplication<Data, Source, Projection extends PBase,
        LocalRepository extends PanacheMongoRepository<Data>,
        ExternalRepository extends PanacheMongoRepository<Source>> {

    void synchronization(Date... dates);
    void delete(Date... dates);
}
