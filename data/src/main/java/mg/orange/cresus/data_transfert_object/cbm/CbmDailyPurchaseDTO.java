package mg.orange.cresus.data_transfert_object.cbm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.mongodb.panache.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true)
public class CbmDailyPurchaseDTO implements Serializable {
    private ObjectId id;
    private Date day;
    private String party_id;
    private String pur_name;
    private String pur_bndle_longname;
}
