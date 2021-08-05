package mg.orange.cresus.controller;

import mg.orange.cresus.application.orange_money.user.ClientOMApplication;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/staging-area/om")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrangeMoneyController {

    @Inject
    ClientOMApplication clientOMApplication;

    @GET
    @Path("/user/sync")
    @Tag(name = "Sync orange money client", description = "Sync local OM client from staging area")
    public void findAllClients(){
        this.clientOMApplication.syncData();
    }
}
