package mg.orange.cresus.domain_object.projection;

import io.quarkus.mongodb.panache.ProjectionFor;
import mg.orange.cresus.domain_object.cbm.CbmDailyUsage;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ProjectionFor(CbmDailyUsage.class)
public class PDailyUsage extends PBase {
    public Document usage;
    public Date day;
    public String party_id;
    public List<Document> roaming;
    public List<Document> topup;
    public List<Document> bundle;
    public List<Document> om;
}
