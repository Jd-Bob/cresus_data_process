package mg.orange.cresus.data_transfert_object;

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

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DailyUsageDTO implements Serializable {
    private ObjectId id;
    private Document usage;
    private List<Document> roaming;
    private List<Document> topup;
    private Date day;
    private String party_id;
    private List<Document> bundle;
    private List<Document> om;
}
