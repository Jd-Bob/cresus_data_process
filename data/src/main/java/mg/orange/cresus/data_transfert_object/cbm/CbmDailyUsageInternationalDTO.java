package mg.orange.cresus.data_transfert_object.cbm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CbmDailyUsageInternationalDTO {
    private ObjectId id;

    private Date day;

    private Document total ;

    private List<Document> roaming;

    private String party_id;

    private List<Document> usage;
}
