package mg.orange.cresus.application.monthlyusage;

import mg.orange.cresus.annotation.Service;
import mg.orange.cresus.application.dailyusage.DailyUsageApplication;
import mg.orange.cresus.application.data.DataApplicationImpl;
import mg.orange.cresus.domain_object.DailyUsage;
import mg.orange.cresus.domain_object.MonthlyUsage;
import mg.orange.cresus.domain_object.cbm.CbmDailyUsage;
import mg.orange.cresus.domain_object.cbm.CbmMonthlyUsage;
import mg.orange.cresus.domain_object.projection.PDailyUsage;
import mg.orange.cresus.domain_object.projection.PMonthlyUsage;
import mg.orange.cresus.repository.CbmDailyUsageRepository;
import mg.orange.cresus.repository.CbmMonthlyUsageRepository;
import mg.orange.cresus.repository.DailyUsageRepository;
import mg.orange.cresus.repository.MonthlyUsageRepository;

import java.util.Date;

@Service
public class MonthlyUsageApplicationImpl extends DataApplicationImpl<MonthlyUsage, CbmMonthlyUsage, PMonthlyUsage,
        MonthlyUsageRepository, CbmMonthlyUsageRepository> implements MonthlyUsageApplication {

    @Override
    public void syncData(Date... dates) {
        this.synchronization(dates);
    }
    @Override
    public  void deleteData(Date... dates){
        this.delete(dates);
    }
}
