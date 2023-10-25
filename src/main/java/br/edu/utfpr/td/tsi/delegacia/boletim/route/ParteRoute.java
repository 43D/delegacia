package br.edu.utfpr.td.tsi.delegacia.boletim.route;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("parte")
public class ParteRoute {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createParte() {
        return Response.ok("Teste bem sucedido: create ").build();
    }

    @PathParam("id")
    private String id;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getParteByID() {
        return Response.ok("Teste bem sucedido: get: " + id).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateParteByID() {
        return Response.ok("Teste bem sucedido: update: " + id).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteParteByID() {
        return Response.ok("Teste bem sucedido: delete: " + id).build();
    }
}
