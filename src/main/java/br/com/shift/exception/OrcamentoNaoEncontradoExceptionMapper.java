package br.com.shift.exception;

import br.com.shift.resource.ApiResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class OrcamentoNaoEncontradoExceptionMapper implements ExceptionMapper<OrcamentoNaoEncontradoException> {

    @Override
    public Response toResponse(OrcamentoNaoEncontradoException e) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ApiResponse("","Error", e.getMessage()))
                .build();
    }

}
