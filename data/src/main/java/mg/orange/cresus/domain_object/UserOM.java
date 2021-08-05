package mg.orange.cresus.domain_object;

import io.quarkus.mongodb.panache.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Date;

@MongoEntity(collection="om_user", clientName = "testbed", database = "dwh")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserOM {

    private ObjectId id;
    private String MS;
    private String UP;
    private String UF;
    private String UL;
    private Date ED;

}