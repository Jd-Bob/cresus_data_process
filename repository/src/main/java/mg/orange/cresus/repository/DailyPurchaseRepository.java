package mg.orange.cresus.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import mg.orange.cresus.domain_object.DailyPurchase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DailyPurchaseRepository implements PanacheMongoRepository<DailyPurchase> {
}
