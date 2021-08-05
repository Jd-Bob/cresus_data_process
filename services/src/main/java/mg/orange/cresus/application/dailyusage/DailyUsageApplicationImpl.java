package mg.orange.cresus.application.dailyusage;

import mg.orange.cresus.annotation.Service;
import mg.orange.cresus.application.data.DataApplicationImpl;
import mg.orange.cresus.domain_object.DailyUsage;
import mg.orange.cresus.domain_object.cbm.CbmDailyUsage;
import mg.orange.cresus.domain_object.projection.PDailyUsage;
import mg.orange.cresus.repository.CbmDailyUsageRepository;
import mg.orange.cresus.repository.DailyUsageRepository;

import java.util.Date;

@Service
public class DailyUsageApplicationImpl extends DataApplicationImpl<DailyUsage, CbmDailyUsage, PDailyUsage,
        DailyUsageRepository, CbmDailyUsageRepository> implements DailyUsageApplication {

    @Override
    public void syncData(Date... dates) {
        this.synchronization(dates);
    }
    @Override
    public  void deleteData(Date... dates){
        this.delete(dates);
    }
}
