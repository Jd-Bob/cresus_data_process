package mg.orange.cresus.domain_object.staging_area;

import io.quarkus.mongodb.panache.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.io.Serializable;

@MongoEntity(collection="sa_client", clientName = "testbed", database = "dwh")
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ClientSA implements Serializable {

//    @BsonProperty("_id")
    private ObjectId id;

    @BsonProperty("MS")
    private String msisdn;

    @BsonProperty("PM")
    private String firstName;

    @BsonProperty("NM")
    private String name;

    @BsonProperty("BD")
    private String birth;

    @BsonProperty("CY")
    private String city;

    @BsonProperty("SN")
    private String serialNumber;

    @BsonProperty("EM")
    private String email;

    @BsonProperty("II")
    private String imsi;

    @BsonProperty("BT")
    private String billingType;

    @BsonProperty("BA")
    private String balance;

    @BsonProperty("AI")
    private String activation;

    @BsonProperty("ET")
    private String activeTenure;

    @BsonProperty("ST")
    private String status;




}
