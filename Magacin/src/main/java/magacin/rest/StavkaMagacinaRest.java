/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.rest;

/**
 *
 * @author Lazar Lazarevic
 */
import magacin.data.StavkaMagacina;
import magacin.exception.MagacinException;
import magacin.service.StavkaMagacinaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/stavke")
public class StavkaMagacinaRest {

    private StavkaMagacinaService stavkaMagacinaService = new StavkaMagacinaService();

    // Endpoint za dobijanje svih stavki magacina
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStavke() {
        try {
            List<StavkaMagacina> stavke = stavkaMagacinaService.getAllStavke();
            return Response.ok(stavke).build();
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error while fetching stavke: " + e.getMessage())
                    .build();
        }
    }

    // Endpoint za dobijanje stavke magacina po ID-u
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStavkaById(@PathParam("id") int id) {
        try {
            StavkaMagacina stavka = stavkaMagacinaService.getStavkaById(id);
            if (stavka == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Stavka with ID " + id + " not found")
                        .build();
            }
            return Response.ok(stavka).build();
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error while fetching stavka: " + e.getMessage())
                    .build();
        }
    }

    // Endpoint za dodavanje nove stavke
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStavka(StavkaMagacina stavka) {
        try {
            stavkaMagacinaService.addStavka(stavka);
            return Response.status(Response.Status.CREATED)
                    .entity(stavka)
                    .build();
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error while adding stavka: " + e.getMessage())
                    .build();
        }
    }

    // Endpoint za ažuriranje stavke
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateStavka(@PathParam("id") int id, StavkaMagacina stavka) {
        try {
            // Postavljanje ID-a stavke jer dolazi kroz URL
            stavka.setProizvodId(id);
            stavkaMagacinaService.updateStavka(stavka);
            return Response.ok(stavka).build();
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error while updating stavka: " + e.getMessage())
                    .build();
        }
    }

    // Endpoint za brisanje stavke
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteStavka(@PathParam("id") int id) {
        try {
            stavkaMagacinaService.deleteStavka(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error while deleting stavka: " + e.getMessage())
                    .build();
        }
    }

    // Endpoint za pretragu stavki po nazivu i tipu
    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchStavke(@QueryParam("naziv") String naziv, @QueryParam("tip") String tip) {
        try {
            List<StavkaMagacina> stavke = stavkaMagacinaService.searchStavke(naziv, tip);
            return Response.ok(stavke).build();
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error while searching stavke: " + e.getMessage())
                    .build();
        }
    }
}
