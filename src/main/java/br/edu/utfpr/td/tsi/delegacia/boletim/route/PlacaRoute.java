package br.edu.utfpr.td.tsi.delegacia.boletim.route;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("placa")
public class PlacaRoute {
    @GET
	public Response teste() {
		return Response.ok("Teste bem sucedido").build();
	}
	
}
