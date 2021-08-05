package mg.orange.cresus.application.dailypurchase;


import java.util.Date;

public interface DailyPurchaseApplication {

    public void syncData(Date... dates);

    public  void deleteData(Date... dates);

}
