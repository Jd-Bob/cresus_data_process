package mg.orange.cresus.domain_object.staging_area;

import com.mongodb.lang.NonNull;
import io.quarkus.mongodb.panache.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.Date;

@MongoEntity(collection="om_usr", clientName = "testbed", database = "dwh")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ClientOM {

    private ObjectId id;

    private String MS;

    private String SO;

    private Date ED;

    private String CT;

    @NonNull
    private String UL;

    @NonNull
    private String UF;

    private String SX;

    private String A2;

    private String UP;

}
