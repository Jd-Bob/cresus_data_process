package mg.orange.cresus.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import mg.orange.cresus.domain_object.DailyUsage;
import mg.orange.cresus.domain_object.DailyUsageInternational;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DailyUsageInternationalRepository implements PanacheMongoRepository<DailyUsageInternational> {
}
