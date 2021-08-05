package mg.orange.cresus.domain_object.projection;

import io.quarkus.mongodb.panache.ProjectionFor;
import mg.orange.cresus.domain_object.cbm.CbmMonthlyUsage;
import org.bson.Document;

import java.util.Date;
import java.util.List;

@ProjectionFor(CbmMonthlyUsage.class)
public class PMonthlyUsage extends PBase{
    public Document total;
    public String day;
    public String party_id;
//    public List<Document> topup;
    public List<Document> bundle;
    public List<Document> usage;
}
