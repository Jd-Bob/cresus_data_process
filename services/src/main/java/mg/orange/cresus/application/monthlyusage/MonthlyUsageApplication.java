package mg.orange.cresus.application.monthlyusage;


import java.util.Date;

public interface MonthlyUsageApplication {

    public void syncData(Date... dates);
    public void deleteData(Date... dates);

}
