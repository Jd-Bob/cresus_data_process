package mg.orange.cresus.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import mg.orange.cresus.domain_object.DailyContracts;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DailyContractRepository implements PanacheMongoRepository<DailyContracts> {
}
