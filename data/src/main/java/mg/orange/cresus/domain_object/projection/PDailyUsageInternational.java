package mg.orange.cresus.domain_object.projection;

import io.quarkus.mongodb.panache.ProjectionFor;
import mg.orange.cresus.domain_object.cbm.CbmDailyUsage;
import mg.orange.cresus.domain_object.cbm.CbmDailyUsageInternational;
import org.bson.Document;

import java.util.Date;
import java.util.List;

@ProjectionFor(CbmDailyUsageInternational.class)
public class PDailyUsageInternational extends PBase {
    public Document total;
    public Date day;
    public String party_id;
//    public List<Document> roaming;
//    public List<Document> usage;
}
