package webservices;

import metiers.LogementBusiness;
import entities.Logement;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/logements")
public class LogementRessources {

    LogementBusiness helper = new LogementBusiness();


    @GET
    @Path("/{reference}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogementByReference(@PathParam("reference") int reference) {
        Logement logement = helper.getLogementsByReference(reference);
        if (logement == null) {
            return Response.status(404).entity("Logement not found").build();
        }
        return Response.status(200).entity(logement).build();
    }


    @POST
    @Path("ajouter")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addLogement(Logement logement) {
        boolean isAdded = helper.addLogement(logement);
        if (isAdded) {
            return Response.status(201).entity(logement).build();
        }
        return Response.status(400).entity("Failed to add logement").build();
    }




    // 4. Mettre à jour un logement
    @PUT
    @Path("/{reference}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLogement(@PathParam("reference") int reference, Logement logement) {
        boolean isUpdated = helper.updateLogement(reference, logement);
        if (isUpdated) {
            return Response.status(200).entity(logement).build();
        }
        return Response.status(404).entity("Logement not found").build();
    }


    @DELETE
    @Path("/{reference}")
    public Response deleteLogement(@PathParam("reference") int reference) {
        boolean isDeleted = helper.deleteLogement(reference);
        if (isDeleted) {
            return Response.status(200).entity("Logement deleted").build();
        }
        return Response.status(404).entity("Logement not found").build();
    }


    @GET
    @Path("/delegation/{deleguation}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogementsByDeleguation(@PathParam("deleguation") String deleguation) {
        List<Logement> logements = helper.getLogementsByDeleguation(deleguation);
        if (logements.isEmpty()) {
            return Response.status(404).entity("No logements found in the given delegation").build();
        }
        return Response.status(200).entity(logements).build();
    }
}


    




