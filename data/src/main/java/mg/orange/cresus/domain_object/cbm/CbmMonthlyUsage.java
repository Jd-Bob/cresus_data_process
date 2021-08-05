package mg.orange.cresus.domain_object.cbm;

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

@MongoEntity(collection="monthly_usage", clientName = "cbm", database = "cbm")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CbmMonthlyUsage implements Serializable {
    private ObjectId id;
    private String day;
    private String party_id;
    private Document total ;
    private List<Document> topup;
    private List<Document> bundle;
    private List<Document> usage;
}
