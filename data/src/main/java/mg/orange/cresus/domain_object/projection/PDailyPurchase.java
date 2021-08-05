package mg.orange.cresus.domain_object.projection;

import io.quarkus.mongodb.panache.ProjectionFor;
import mg.orange.cresus.domain_object.cbm.CbmDailyPurchase;
import org.bson.types.ObjectId;

import java.util.Date;

@ProjectionFor(CbmDailyPurchase.class)
public class PDailyPurchase extends PBase{
    public Date day;
    public String party_id;
    public String pur_name;
    public String pur_bndle_longname;
}
