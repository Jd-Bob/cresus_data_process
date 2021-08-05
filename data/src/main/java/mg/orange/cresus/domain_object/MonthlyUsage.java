package mg.orange.cresus.domain_object;

import io.quarkus.mongodb.panache.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;

@MongoEntity(collection="monthly_usage", clientName = "testbed", database = "cresus")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MonthlyUsage implements Serializable {
    private ObjectId id;
    private String day;
    private String party_id;
    private Document total ;
    private List<Document> topup;
    private List<Document> bundle;
    private List<Document> usage;
}
