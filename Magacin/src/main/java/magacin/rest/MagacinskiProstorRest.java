/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.rest;

/**
 *
 * @author Lazar Lazarevic
 */
import magacin.data.MagacinskiProstor;
import magacin.exception.MagacinException;
import magacin.service.MagacinskiProstorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/magacinskiProstor")
public class MagacinskiProstorRest {

    private final MagacinskiProstorService magacinskiProstorService = new MagacinskiProstorService();

    // POST metoda za dodavanje magacinskog prostora
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMagacinskiProstor(MagacinskiProstor magacinskiProstor) {
        try {
            magacinskiProstorService.addMagacinskiProstor(magacinskiProstor);
            return Response.status(Response.Status.CREATED).entity(magacinskiProstor).build();
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error creating Magacinski Prostor").build();
        }
    }

    // PUT metoda za ažuriranje magacinskog prostora
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMagacinskiProstor(MagacinskiProstor magacinskiProstor) {
        try {
            magacinskiProstorService.updateMagacinskiProstor(magacinskiProstor);
            return Response.status(Response.Status.OK).entity(magacinskiProstor).build();
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error updating Magacinski Prostor").build();
        }
    }

    // DELETE metoda za brisanje magacinskog prostora
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMagacinskiProstor(@PathParam("id") int id) {
        try {
            magacinskiProstorService.deleteMagacinskiProstor(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error deleting Magacinski Prostor").build();
        }
    }

    // GET metoda za dobijanje svih magacinskih prostora
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMagacinskiProstori() {
        try {
            List<MagacinskiProstor> prostori = magacinskiProstorService.getAllMagacinskiProstori();
            return Response.status(Response.Status.OK).entity(prostori).build();
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error fetching Magacinski Prostori").build();
        }
    }

    // GET metoda za dobijanje magacinskog prostora po ID-u
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMagacinskiProstorById(@PathParam("id") int id) {
        try {
            MagacinskiProstor magacinskiProstor = magacinskiProstorService.getMagacinskiProstorById(id);
            if (magacinskiProstor == null) {
                return Response.status(Response.Status.NOT_FOUND).entity("Magacinski prostor not found").build();
            }
            return Response.status(Response.Status.OK).entity(magacinskiProstor).build();
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error fetching Magacinski Prostor").build();
        }
    }
}