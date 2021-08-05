package mg.orange.cresus.domain_object;

import io.quarkus.mongodb.panache.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@MongoEntity(collection="daily_usage", clientName = "testbed", database = "cresus")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DailyUsage implements Serializable {
    private ObjectId id;
    private Document usage;
    private List<Document> roaming;
    private List<Document> topup;
    private Date day;
    private String party_id;
    private List<Document> bundle;
    private List<Document> om;
}
