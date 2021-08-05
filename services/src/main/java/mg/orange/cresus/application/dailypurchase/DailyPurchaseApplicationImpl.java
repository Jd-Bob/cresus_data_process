package mg.orange.cresus.application.dailypurchase;

import mg.orange.cresus.annotation.Service;
import mg.orange.cresus.application.data.DataApplicationImpl;
import mg.orange.cresus.domain_object.DailyPurchase;
import mg.orange.cresus.domain_object.cbm.CbmDailyPurchase;
import mg.orange.cresus.domain_object.projection.PDailyPurchase;
import mg.orange.cresus.repository.CbmDailyPurchaseRepository;
import mg.orange.cresus.repository.DailyPurchaseRepository;


import java.util.Date;

@Service
public class DailyPurchaseApplicationImpl extends DataApplicationImpl<DailyPurchase, CbmDailyPurchase, PDailyPurchase,
        DailyPurchaseRepository, CbmDailyPurchaseRepository> implements DailyPurchaseApplication {

    @Override
    public void syncData(Date... dates) {
        this.synchronization(dates);
    }

    @Override
    public  void deleteData(Date... dates){
        this.delete(dates);
    }
}
