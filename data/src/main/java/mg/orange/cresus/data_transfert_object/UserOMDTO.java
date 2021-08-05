package mg.orange.cresus.data_transfert_object;

import io.quarkus.mongodb.panache.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserOMDTO {

    private ObjectId id;
    private String msisdn;
    private String title;
    private String firstname;
    private String name;

}
