package mg.orange.cresus.job;

import io.quarkus.scheduler.Scheduled;
import mg.orange.cresus.application.monthlyusage.MonthlyUsageApplication;
import mg.orange.cresus.enumerator.DateFormat;
import mg.orange.cresus.utils.DateTimeUtils;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;

public class MonthlyUsageScheduleTask {

    @Inject
    MonthlyUsageApplication monthlyUsageApplication;

    @Scheduled(cron = "0 30 8 * * ?")
    void sync(){
        Date today = DateTimeUtils.parsDate(new Date(), DateFormat.YYYYMMDD_DASH.getValue());
        Date sixMonths =  DateTimeUtils.jump(today, Calendar.MONTH,-6);

        this.monthlyUsageApplication.syncData(sixMonths, today);

    }
    @Scheduled(cron = "0 17 8 1 * ?")
    void update() {
        this.monthlyUsageApplication.syncData(new Date());
    }

    @Scheduled(cron = "0 30 8 1 * ?")
    void delete() {
        Date today = DateTimeUtils.parsDate(new Date(), DateFormat.YYYYMMDD_DASH.getValue());
        Date sixMonths = DateTimeUtils.jump(today, Calendar.MONTH, -6);
        this.monthlyUsageApplication.deleteData(sixMonths);
    }
}
