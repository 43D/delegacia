package br.edu.utfpr.td.tsi.delegacia.boletim.route;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("boletim")
public class BoletimRoute {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response teste() {

        return Response.ok("Teste bem sucedido").build();
    }
}
