package mg.orange.cresus.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import mg.orange.cresus.domain_object.Client;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientRepository implements PanacheMongoRepository<Client> {
}
