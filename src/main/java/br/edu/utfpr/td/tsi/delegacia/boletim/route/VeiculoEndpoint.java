package br.edu.utfpr.td.tsi.delegacia.boletim.route;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.delegacia.boletim.entity.Veiculo;
import br.edu.utfpr.td.tsi.delegacia.boletim.repository.VeiculoRepository;
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
    VeiculoRepository repository;

    @QueryParam("page")
    private String page;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVeiculos() {
        List<Veiculo> veiculos = repository.findAll();
        return Response.ok(veiculos).build();
    }

    @PathParam("id")
    private String id;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getVeiculoByID() {
        Long idLong = Long.parseLong(id);
        Optional<Veiculo> veiculo = repository.findById(idLong);
        if (!veiculo.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(veiculo.get()).build();
    }
}
