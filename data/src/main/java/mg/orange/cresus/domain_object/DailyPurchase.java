package mg.orange.cresus.domain_object;

import io.quarkus.mongodb.panache.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Date;

@MongoEntity(collection="daily_purchase", clientName = "testbed", database = "cresus")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DailyPurchase {
    private ObjectId id;
    private Date day;
    private String party_id;
    private String pur_name;
    private String pur_bndle_longname;
}
