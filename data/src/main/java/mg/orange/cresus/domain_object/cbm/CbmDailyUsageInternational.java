package mg.orange.cresus.domain_object.cbm;

import io.quarkus.mongodb.panache.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@MongoEntity(collection="daily_usage_international", clientName = "cbm", database = "cbm")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CbmDailyUsageInternational implements Serializable {
    private ObjectId id;

    @BsonProperty("day")
    private Date day;

    @BsonProperty("total")
    private Document total ;

    private List<Document> roaming;

    private String party_id;

    private List<Document> usage;


}
