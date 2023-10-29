package br.edu.utfpr.td.tsi.delegacia.route;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import br.edu.utfpr.td.tsi.delegacia.entity.Veiculo;
import br.edu.utfpr.td.tsi.delegacia.repository.VeiculoRepository;
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
    VeiculoRepository repository;

    @QueryParam("page")
    @DefaultValue("1")
    private int page;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVeiculos() {
        Pageable pageable = PageRequest.of(page - 1, 50);
        Page<Veiculo> veiculos = repository.findAll(pageable);
        List<Veiculo> veiculosList = veiculos.getContent();
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
        Optional<Veiculo> veiculo = repository.findById(id);
        if (!veiculo.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Veiculo não encontrado")
                    .build();
        }
        return Response.ok(veiculo.get()).build();
    }
}
