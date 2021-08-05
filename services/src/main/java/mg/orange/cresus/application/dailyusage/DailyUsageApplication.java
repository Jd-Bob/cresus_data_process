package mg.orange.cresus.application.dailyusage;


import java.util.Date;

public interface DailyUsageApplication {

    public void syncData(Date... dates);
    public void deleteData(Date... dates);

}
