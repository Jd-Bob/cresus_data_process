package mg.orange.cresus.beans;

import io.quarkus.mongodb.panache.MongoEntity;

@MongoEntity(collection="daily_usage_international", clientName = "cbm", database = "cbm")
public class CbmDailyUsageInternationalBean {

}
