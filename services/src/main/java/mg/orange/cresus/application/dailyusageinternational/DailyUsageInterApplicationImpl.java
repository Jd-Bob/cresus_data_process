package mg.orange.cresus.application.dailyusageinternational;

import mg.orange.cresus.annotation.Service;
import mg.orange.cresus.application.data.DataApplicationImpl;
import mg.orange.cresus.domain_object.DailyUsageInternational;
import mg.orange.cresus.domain_object.cbm.CbmDailyUsageInternational;
import mg.orange.cresus.domain_object.projection.PDailyUsageInternational;
import mg.orange.cresus.repository.CbmDailyUsageInternationalRepository;
import mg.orange.cresus.repository.DailyUsageInternationalRepository;
import java.util.Date;

@Service
public class DailyUsageInterApplicationImpl extends DataApplicationImpl<DailyUsageInternational, CbmDailyUsageInternational, PDailyUsageInternational,
        DailyUsageInternationalRepository, CbmDailyUsageInternationalRepository> implements DailyUsageInterApplication {
    @Override
    public void syncData(Date...dates) {
        this.synchronization(dates);
    }
}
