package br.com.shift.resource;

import br.com.shift.entity.Orcamento;
import br.com.shift.service.IOrcamentoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/orcamento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrcamentoResource {

    private final IOrcamentoService orcamentoService;

    public OrcamentoResource(IOrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @GET
    public Response retornarOrcamentos(@QueryParam("idFonte") int idFonte,
                                       @QueryParam("idPessoa") int idPessoa) {

        if (idFonte == 0 && idPessoa == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.ok(orcamentoService.retornarPorFonteOuPessoa(idFonte, idPessoa)).build();

    }

    @GET
    @Path("/{idOrcamento}")
    public Response retornarOrcamentoPorId(int idOrcamento) {

        if (idOrcamento <= 0) {
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), "Id inválido").build();
        }

        return Response.ok(orcamentoService.retornarPorId(idOrcamento)).build();

    }

    @POST
    public Response novoOrcamento(Orcamento orcamento) {
        return Response.ok(orcamentoService.criar(orcamento)).build();
    }

    @PUT
    public Response atualizarOrcamento(Orcamento orcamento) {
        return Response.ok(orcamentoService.atualizar(orcamento)).build();
    }

    @DELETE
    @Path("/{idOrcamento}")
    public Response removerOrcamento(int idOrcamento) {
        orcamentoService.deletar(idOrcamento);
        return Response.ok().build();
    }

}
