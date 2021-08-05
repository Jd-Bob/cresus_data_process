package mg.orange.cresus.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import mg.orange.cresus.domain_object.cbm.CbmDailyUsage;
import mg.orange.cresus.domain_object.cbm.CbmDailyUsageInternational;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CbmDailyUsageInternationalRepository implements PanacheMongoRepository<CbmDailyUsageInternational> {
}
