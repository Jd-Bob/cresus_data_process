package mg.orange.cresus.application.dailycontract;


import java.util.Date;

public interface DailyContractsApplication {

    public void syncData();

    public  void deleteData(Date... dates);

}
