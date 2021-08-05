package mg.orange.cresus.job;

import io.quarkus.scheduler.Scheduled;
import mg.orange.cresus.application.dailycontract.DailyContractsApplication;
import mg.orange.cresus.enumerator.DateFormat;
import mg.orange.cresus.utils.DateTimeUtils;
import mg.orange.cresus.utils.DateUtils;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;

public class DailyContratScheduleTask {

    @Inject
    DailyContractsApplication dailyContractsApplication;

    @Scheduled(cron = "0 55 8 * * ?")
    void sync(){
        this.dailyContractsApplication.syncData();
    }

    @Scheduled(cron = "0 38 9 * * ?")
    void deleteDailyContract(){

        Date today = DateTimeUtils.parsDate(new Date(), DateFormat.YYYYMMDD_DASH.getValue());
        Date dateToDelete = DateTimeUtils.jump(today, Calendar.DATE, -1);
        System.out.println("dateToDelete====>" + dateToDelete);
        System.out.println("DELETE DAILY_CONTRAT......");
        this.dailyContractsApplication.deleteData(dateToDelete);
        System.out.println("DELETE  END----->");
    }


}
