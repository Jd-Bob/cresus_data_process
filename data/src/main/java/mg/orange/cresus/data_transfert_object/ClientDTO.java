package mg.orange.cresus.data_transfert_object;

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
public class ClientDTO implements Serializable {

    private ObjectId id;

    private String msisdn;

    private String firstName;

    private String name;

    private String birth;

    private String city;

    private String billingType;

}
