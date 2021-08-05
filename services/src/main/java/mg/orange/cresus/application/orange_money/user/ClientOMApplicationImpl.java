package mg.orange.cresus.application.orange_money.user;

import mg.orange.cresus.annotation.Service;
import mg.orange.cresus.application.data.DataApplicationImpl;
import mg.orange.cresus.domain_object.UserOM;
import mg.orange.cresus.domain_object.projection.PClientOM;
import mg.orange.cresus.domain_object.staging_area.ClientOM;
import mg.orange.cresus.repository.ClientOMRepository;
import mg.orange.cresus.repository.UserOMRepository;

@Service
public class ClientOMApplicationImpl extends DataApplicationImpl<UserOM, ClientOM,
        PClientOM, UserOMRepository, ClientOMRepository> implements ClientOMApplication {

    @Override
    public void syncData() {
        this.synchronization();
    }
}
