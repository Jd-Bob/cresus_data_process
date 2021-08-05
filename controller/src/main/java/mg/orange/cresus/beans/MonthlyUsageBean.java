package mg.orange.cresus.beans;

import io.quarkus.mongodb.panache.MongoEntity;


import java.io.Serializable;
import java.util.List;

@MongoEntity(collection="monthly_usage", clientName = "testbed", database = "cresus")
public class MonthlyUsageBean implements Serializable {
}
