package br.edu.utfpr.td.tsi.delegacia.boletim.route;

import jakarta.ws.rs.PathParam;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import br.edu.utfpr.td.tsi.delegacia.boletim.entity.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.boletim.repository.BoletimRepository;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("boletim")
public class BoletimEndpoint {
    @Autowired
    BoletimRepository repository;

    @QueryParam("page")
    @DefaultValue("1")
    private int page;
    Pageable pageable = PageRequest.of(page, 50);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBoletins() {
        Page<BoletimFurtoVeiculo> boletins = repository.findAll(pageable);
        List<BoletimFurtoVeiculo> boletinsList = boletins.getContent();
        if (boletinsList.size() == 0 && page > 1)
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Paginação invalida")
                    .build();
        return Response.ok(boletinsList).build();
    }

    @PathParam("id")
    private long id;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getBoletimByID() {
        Optional<BoletimFurtoVeiculo> boletins = repository.findById(id);

        if (!boletins.isPresent()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Boletim não encontrado")
                    .build();
        }
        return Response.ok(boletins.get()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBoletim(BoletimFurtoVeiculo bo) {
        repository.save(bo);
        bo.getVeiculoFurtado().setEnvolvidoEm(bo);
        return Response.ok(bo).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateBoletimByID(BoletimFurtoVeiculo bo) {

        return Response.ok(bo).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteBoletimByID() {
        return Response.ok("Teste bem sucedido: delete: " + id).build();
    }

}
