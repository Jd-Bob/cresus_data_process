package mg.orange.cresus.data_transfert_object;

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
public class DailyUsageInternationalDTO implements Serializable {
    private ObjectId id;
    private Document total;
    private List<Document> roaming;
    private List<Document> usage;
    private Date day;
    private String party_id;
}
