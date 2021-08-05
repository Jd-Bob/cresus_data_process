package mg.orange.cresus.beans;

import io.quarkus.mongodb.panache.MongoEntity;
@MongoEntity(collection="daily_usage", clientName = "cbm", database = "cbm")
public class CbmDailyUsageBean {

}
