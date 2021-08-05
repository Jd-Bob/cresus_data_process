package mg.orange.cresus.repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import mg.orange.cresus.domain_object.staging_area.ClientOM;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientOMRepository implements PanacheMongoRepository<ClientOM> {

}
