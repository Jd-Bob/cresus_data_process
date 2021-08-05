package mg.orange.cresus.beans;

import io.quarkus.mongodb.panache.MongoEntity;

@MongoEntity(collection="daily_contracts", clientName = "testbed", database = "cresus")
public class DailyContracts {

}
