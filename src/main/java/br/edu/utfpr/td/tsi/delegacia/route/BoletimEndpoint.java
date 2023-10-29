package br.edu.utfpr.td.tsi.delegacia.route;

import jakarta.ws.rs.PathParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.utfpr.td.tsi.delegacia.entity.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.exception.EntidadeInexistenteException;
import br.edu.utfpr.td.tsi.delegacia.services.boletim.iBoletimServices;
import br.edu.utfpr.td.tsi.delegacia.specification.BoletimFurtoVeiculoSpecification;
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
    iBoletimServices boletimService;

    @QueryParam("page")
    @DefaultValue("1")
    private int page;

    @QueryParam("cidade")
    @DefaultValue("")
    private String cidade;

    @QueryParam("periodo")
    @DefaultValue("")
    private String periodo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBoletins() {
        List<BoletimFurtoVeiculo> boletinsList = boletimService.getBoletimPage(page, cidade, periodo);
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
        BoletimFurtoVeiculo bo = boletimService.getBoletimById(id);

        if (bo == null)
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Boletim não encontrado")
                    .build();

        return Response.ok(bo).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBoletim(BoletimFurtoVeiculo bo) {
        if (bo == null)
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Objeto de entrada ausente!!")
                    .build();

        if (!BoletimFurtoVeiculoSpecification.checkBoletimFurtoVeiculoSpecification(bo))
            return Response.status(Response.Status.BAD_REQUEST).entity("Valores ausentes no objeto!!!").build();

        BoletimFurtoVeiculo boSaved = boletimService.createBoletimId(bo);

        return Response.status(Response.Status.CREATED).entity(boSaved).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response updateBoletimByID(BoletimFurtoVeiculo bo) {
        if (bo == null)
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Objeto de entrada ausente!!")
                    .build();

        if (!BoletimFurtoVeiculoSpecification.checkBoletimFurtoVeiculoSpecification(bo))
            return Response.status(Response.Status.BAD_REQUEST).entity("Valores ausentes no objeto!!!").build();

        try {
            BoletimFurtoVeiculo boUpdated = boletimService.updateBoletim(bo, id);
            return Response.status(Response.Status.CREATED).entity(boUpdated).build();
        } catch (EntidadeInexistenteException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteBoletimByID() {
        try {
            boletimService.deleteBoletimByID(id);
        } catch (EntidadeInexistenteException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
        return Response.ok("deletado ").build();
    }

}
