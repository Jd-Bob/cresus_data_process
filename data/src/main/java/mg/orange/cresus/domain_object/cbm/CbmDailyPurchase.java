package mg.orange.cresus.domain_object.cbm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.mongodb.panache.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;

@MongoEntity(collection="daily_purchase", clientName = "cbm", database = "cbm")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class CbmDailyPurchase implements Serializable {
    private ObjectId id;
    private Date day;
    private String party_id;
    private String pur_name;
    private String pur_bndle_longname;
}
