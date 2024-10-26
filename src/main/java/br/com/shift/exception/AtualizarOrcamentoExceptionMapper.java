package br.com.shift.exception;

import br.com.shift.resource.ApiResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class AtualizarOrcamentoExceptionMapper implements ExceptionMapper<AtualizarOrcamentoException> {

    @Override
    public Response toResponse(AtualizarOrcamentoException e) {
        return Response.status(422)
                .entity(new ApiResponse("", "Error", e.getMessage()))
                .build();
    }

}
