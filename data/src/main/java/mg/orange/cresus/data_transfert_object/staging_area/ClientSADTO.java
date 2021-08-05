package mg.orange.cresus.data_transfert_object.staging_area;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ClientSADTO implements Serializable {

    private ObjectId id;
    private String msisdn;
    private String firstName;
    private String name;
    private String birth;
    private String city;
    private String serialNumber;
    private String email;
    private String imsi;
    private String billingType;
    private String balance;
    private String activation;
    private String activeTenure;
    private String status;

}
