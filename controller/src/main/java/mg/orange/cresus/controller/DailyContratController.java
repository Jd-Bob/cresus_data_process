package mg.orange.cresus.controller;

import mg.orange.cresus.application.dailycontract.DailyContractsApplication;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cbm/dailycontrat")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DailyContratController {

    @Inject
    DailyContractsApplication dailyContractsApplication;

    @GET
    @Path("/sync")
    @Tag(name = "Sync client", description = "Sync local client from staging area")
    public void findAllClients(){
        this.dailyContractsApplication.syncData();
    }
}
