package mg.orange.cresus.job;

import io.quarkus.scheduler.Scheduled;
import mg.orange.cresus.enumerator.DateFormat;
import mg.orange.cresus.application.dailyusage.DailyUsageApplication;
import mg.orange.cresus.utils.DateTimeUtils;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;

public class DailyUsageScheduleTask {

    @Inject
    DailyUsageApplication dailyUsageApplication;

    @Scheduled(cron = "0 0 8 * * ?")
    void sync(){
        Date today = DateTimeUtils.parsDate(new Date(), DateFormat.YYYYMMDD_DASH.getValue());
        Date sixMonths =  DateTimeUtils.jump(today, Calendar.MONTH,-6);

        this.dailyUsageApplication.syncData(sixMonths, today);

    }
    @Scheduled(cron = "0  16 8 * * ?")
    void update() {
        this.dailyUsageApplication.syncData(new Date());
    }

    @Scheduled(cron = "0 4 8 * * ?")
    void delete() {
        Date today = DateTimeUtils.parsDate(new Date(), DateFormat.YYYYMMDD_DASH.getValue());
        Date sixMonths = DateTimeUtils.jump(today, Calendar.MONTH, -6);
        Date dateToDelete = DateTimeUtils.jump(sixMonths, Calendar.DATE, -2);

        this.dailyUsageApplication.deleteData(dateToDelete);
    }
}
