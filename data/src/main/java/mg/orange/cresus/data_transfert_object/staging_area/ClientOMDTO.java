package mg.orange.cresus.data_transfert_object.staging_area;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ClientOMDTO {

    private ObjectId id;
    private String msisdn;
    private String title;
    private String firstname;
    private String name;

}
