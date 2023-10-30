package br.edu.utfpr.td.tsi.delegacia.route;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.delegacia.entity.Veiculo;
import br.edu.utfpr.td.tsi.delegacia.exception.EntidadeInexistenteException;
import br.edu.utfpr.td.tsi.delegacia.services.veiculo.iVeiculoServices;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("veiculo")
public class VeiculoEndpoint {
    @Autowired
    iVeiculoServices veiculoServices;

    @QueryParam("page")
    @DefaultValue("1")
    private int page;

    @QueryParam("placa")
    @DefaultValue("")
    private String placa;

    @QueryParam("cor")
    @DefaultValue("")
    private String cor;

    @QueryParam("tipo")
    @DefaultValue("")
    private String tipo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVeiculos() {
        List<Veiculo> veiculosList = veiculoServices.getVeiculoPage(page, placa, cor, tipo);
        if (veiculosList.size() == 0 && page > 1)
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Paginação invalida")
                    .build();
        return Response.ok(veiculosList).build();
    }

    @PathParam("id")
    private Long id;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getVeiculoByID() {
        try {
            Veiculo veiculo = veiculoServices.getVeiculoById(id);
            return Response.ok(veiculo).build();
        } catch (EntidadeInexistenteException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }
}
