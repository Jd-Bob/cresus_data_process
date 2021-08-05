package mg.orange.cresus.controller;

import mg.orange.cresus.application.clients.ClientApplication;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/staging-area/client")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientController {

    @Inject
    ClientApplication clientsApplication;

    @GET
    @Path("/sync")
    @Tag(name = "Sync client", description = "Sync local client from staging area")
    public void findAllClients(){
        this.clientsApplication.syncData();
    }
}
