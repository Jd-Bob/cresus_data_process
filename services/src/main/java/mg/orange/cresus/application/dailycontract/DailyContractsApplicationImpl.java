package mg.orange.cresus.application.dailycontract;

import mg.orange.cresus.annotation.Service;
import mg.orange.cresus.application.data.DataApplicationImpl;
import mg.orange.cresus.domain_object.DailyContracts;
import mg.orange.cresus.domain_object.cbm.CbmDailyContrat;
import mg.orange.cresus.domain_object.projection.PDailyContrat;
import mg.orange.cresus.repository.CbmDailyContractRepository;
import mg.orange.cresus.repository.DailyContractRepository;

import java.util.Date;

@Service
public class DailyContractsApplicationImpl extends DataApplicationImpl<DailyContracts, CbmDailyContrat, PDailyContrat,
        DailyContractRepository, CbmDailyContractRepository> implements DailyContractsApplication {

    @Override
    public void syncData() {
        this.synchronization();
    }

    @Override
    public  void deleteData(Date... dates){
        this.delete(dates);
    }
}
