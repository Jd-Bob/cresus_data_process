package mg.orange.cresus.domain_object;

import io.quarkus.mongodb.panache.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.io.Serializable;

@MongoEntity(collection="client", clientName = "localhost", database = "datasources")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {

    private ObjectId id;

    private String msisdn;

    private String firstName;

    private String name;

    private String birth;

    private String city;

    private String billingType;

}
