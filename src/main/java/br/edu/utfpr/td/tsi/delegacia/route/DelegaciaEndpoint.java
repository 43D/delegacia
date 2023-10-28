package br.edu.utfpr.td.tsi.delegacia.route;

import jakarta.json.Json;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("")
public class DelegaciaEndpoint {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response api() {
        String json = Json.createObjectBuilder()
                .add("pages", Json.createArrayBuilder()
                        .add("boletim")
                        .add("veiculo"))
                .build().
                toString();
        return Response.ok(json).build();
    }
}
