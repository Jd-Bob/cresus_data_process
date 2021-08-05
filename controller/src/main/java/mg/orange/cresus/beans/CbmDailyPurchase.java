package mg.orange.cresus.beans;

import io.quarkus.mongodb.panache.MongoEntity;

@MongoEntity(collection="daily_purchase", clientName = "cbm", database = "cbm")
public class CbmDailyPurchase {

}
