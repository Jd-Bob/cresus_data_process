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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@MongoEntity(collection="daily_usage", clientName = "cbm", database = "cbm")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CbmDailyUsage implements Serializable {
    private ObjectId id;

    @BsonProperty("day")
    private Date day;

    @BsonProperty("usage")
    private Document usage ;

    private List<Document> roaming;

    private String party_id;

    private List<Document> topup;

    private List<Document> bundle;

    private List<Document> om;

}
