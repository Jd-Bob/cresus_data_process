package mg.orange.cresus.controller;

import mg.orange.cresus.application.dailyusage.DailyUsageApplication;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cbm/dailyusage")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DailyUsageController {

    @Inject
    DailyUsageApplication dailyUsageApplication;

    @GET
    @Path("/sync")
    @Tag(name = "Sync client", description = "Sync local client from cbm")
    public void findAllClients(){
        this.dailyUsageApplication.syncData();
    }
}
