package mg.orange.cresus.domain_object;

import io.quarkus.mongodb.panache.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@MongoEntity(collection="daily_usage_international", clientName = "testbed", database = "cresus")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DailyUsageInternational implements Serializable {
    private ObjectId id;
    private Document total;
    private List<Document> roaming;
    private List<Document> usage;
    private Date day;
    private String party_id;
}
