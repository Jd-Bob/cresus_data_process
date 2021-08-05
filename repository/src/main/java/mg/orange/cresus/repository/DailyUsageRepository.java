package mg.orange.cresus.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import mg.orange.cresus.domain_object.DailyUsage;
import mg.orange.cresus.domain_object.cbm.CbmDailyUsage;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DailyUsageRepository implements PanacheMongoRepository<DailyUsage> {
}
