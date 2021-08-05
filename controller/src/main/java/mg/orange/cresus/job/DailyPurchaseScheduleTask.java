package mg.orange.cresus.job;

import io.quarkus.scheduler.Scheduled;
import mg.orange.cresus.application.dailypurchase.DailyPurchaseApplication;
import mg.orange.cresus.enumerator.DateFormat;
import mg.orange.cresus.utils.DateTimeUtils;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;

public class DailyPurchaseScheduleTask {

    @Inject
    DailyPurchaseApplication dailyPurchaseApplication;

    @Scheduled(cron = "0 03 15 * * ?")
    void sync(){
        Date today = DateTimeUtils.parsDate(new Date(), DateFormat.YYYYMMDD_DASH.getValue());
        Date sixMonths =  DateTimeUtils.jump(today, Calendar.MONTH,-6);

        this.dailyPurchaseApplication.syncData(sixMonths, today);
    }

    @Scheduled(cron = "0 38 9 * * ?")
    void deleteDailyContract(){

        Date today = DateTimeUtils.parsDate(new Date(), DateFormat.YYYYMMDD_DASH.getValue());
        Date dateToDelete = DateTimeUtils.jump(today, Calendar.DATE, -1);
        System.out.println("dateToDelete====>" + dateToDelete);
        System.out.println("DELETE DAILY_CONTRAT......");
        this.dailyPurchaseApplication.deleteData(dateToDelete);
        System.out.println("DELETE  END----->");
    }


}
