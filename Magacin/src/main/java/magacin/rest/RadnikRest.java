/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magacin.rest;

/**
 *
 * @author Lazar Lazarevic
 */
import magacin.data.Radnik;
import magacin.exception.MagacinException;
import magacin.service.RadnikService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/radnici")
public class RadnikRest {

    private RadnikService radnikService;

    public RadnikRest() {
        this.radnikService = new RadnikService();
    }

    // Kreiranje novog radnika (POST)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRadnik(Radnik radnik) {
        try {
            radnikService.addRadnik(radnik);
            return Response.status(Response.Status.CREATED).entity(radnik).build();
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error creating radnik: " + e.getMessage()).build();
        }
    }

    // Dohvatanje svih radnika (GET)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRadnici() {
        try {
            List<Radnik> radnici = radnikService.getAllRadnici();
            return Response.status(Response.Status.OK).entity(radnici).build();
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error fetching radnici: " + e.getMessage()).build();
        }
    }

    // Dohvatanje radnika po ID-u (GET)
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRadnikById(@PathParam("id") int id) {
        try {
            Radnik radnik = radnikService.getRadnikById(id);
            if (radnik != null) {
                return Response.status(Response.Status.OK).entity(radnik).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Radnik not found").build();
            }
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error fetching radnik: " + e.getMessage()).build();
        }
    }

    // Ažuriranje radnika (PUT)
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRadnik(@PathParam("id") int id, Radnik radnik) {
        try {
            radnik.setId(id); // Set the ID of the radnik to update
            radnikService.updateRadnik(radnik);
            return Response.status(Response.Status.OK).entity(radnik).build();
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error updating radnik: " + e.getMessage()).build();
        }
    }

    // Brisanje radnika (DELETE)
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRadnik(@PathParam("id") int id) {
        try {
            radnikService.deleteRadnik(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error deleting radnik: " + e.getMessage()).build();
        }
    }
    
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Radnik loginDetails) {
        try {
            Radnik radnik = radnikService.login(loginDetails.getUsername(), loginDetails.getPassword());

            if (radnik != null) {
                return Response.status(Response.Status.OK).entity(radnik).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("Invalid username or password").build();
            }
        } catch (MagacinException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error while logging in: " + e.getMessage()).build();
        }
    }
}