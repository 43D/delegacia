package br.edu.utfpr.td.tsi.delegacia.boletim.route;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("veiculo")
public class VeiculoRoute {
    @GET
    public Response teste() {
        return Response.ok("Teste bem sucedido").build();
    }
}
