package mg.orange.cresus.domain_object.projection;

import com.mongodb.lang.NonNull;
import io.quarkus.mongodb.panache.ProjectionFor;
import mg.orange.cresus.domain_object.staging_area.ClientOM;

import java.util.Date;

@ProjectionFor(ClientOM.class)
public class PClientOM extends PBase {

    public String MS;
    public String UP;
    public String UF;
    public String UL;
    public Date ED;

}