package mg.orange.cresus.beans;

import io.quarkus.mongodb.panache.MongoEntity;

@MongoEntity(collection="daily_purchase", clientName = "testbed", database = "cresus")
public class DailyPurchase {

}
