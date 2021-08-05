package mg.orange.cresus.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import mg.orange.cresus.domain_object.cbm.CbmDailyContrat;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CbmDailyContractRepository implements PanacheMongoRepository<CbmDailyContrat> {
}
