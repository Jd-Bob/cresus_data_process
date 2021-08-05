package mg.orange.cresus.application.clients;

import mg.orange.cresus.annotation.Service;
import mg.orange.cresus.application.data.DataApplicationImpl;
import mg.orange.cresus.domain_object.Client;
import mg.orange.cresus.domain_object.projection.PClient;
import mg.orange.cresus.domain_object.staging_area.ClientSA;
import mg.orange.cresus.repository.ClientRepository;
import mg.orange.cresus.repository.ClientSARepository;

@Service
public class ClientApplicationImpl extends DataApplicationImpl<Client, ClientSA, PClient,
        ClientRepository, ClientSARepository> implements ClientApplication {

    @Override
    public void syncData() {
        this.synchronization();
    }
}
