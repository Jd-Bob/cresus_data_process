package mg.orange.cresus.beans;

import io.quarkus.mongodb.panache.MongoEntity;
import java.io.Serializable;

@MongoEntity(collection="daily_usage",clientName = "testbed", database = "cresus")
public class DailyUsage implements Serializable {

}
