package br.edu.utfpr.td.tsi.delegacia.boletim.route;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("placa")
public class PlacaRoute {
    @QueryParam("page")
    private String page;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBoletins() {
        return Response.ok("Teste bem sucedido: a: " + page).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPlaca() {
        return Response.ok("Teste bem sucedido: create ").build();
    }

    @PathParam("id")
    private String id;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getPlacaByID() {
        return Response.ok("Teste bem sucedido: get: " + id).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updatePlacaByID() {
        return Response.ok("Teste bem sucedido: update: " + id).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deletePlacaByID() {
        return Response.ok("Teste bem sucedido: delete: " + id).build();
    }
	
}