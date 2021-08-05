package mg.orange.cresus.domain_object.projection;

import io.quarkus.mongodb.panache.ProjectionFor;
import mg.orange.cresus.domain_object.staging_area.ClientSA;

@ProjectionFor(ClientSA.class)
public class PClient extends PBase {

    public String msisdn;
    public String firstName;
    public String name;
    public String birth;
    public String city;
    public String billingType;

}
