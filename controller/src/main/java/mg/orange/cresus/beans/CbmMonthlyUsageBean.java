package mg.orange.cresus.beans;

import io.quarkus.mongodb.panache.MongoEntity;

import java.io.Serializable;
@MongoEntity(collection="monthly_usage", clientName = "cbm", database = "cbm")
public class CbmMonthlyUsageBean implements Serializable {
}
