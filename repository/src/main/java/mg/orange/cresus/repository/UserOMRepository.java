package mg.orange.cresus.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import mg.orange.cresus.domain_object.UserOM;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserOMRepository implements PanacheMongoRepository<UserOM> {
}
