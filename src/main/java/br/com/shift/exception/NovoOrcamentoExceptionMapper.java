package br.com.shift.exception;

import br.com.shift.resource.ApiResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NovoOrcamentoExceptionMapper implements ExceptionMapper<NovoOrcamentoException> {

    @Override
    public Response toResponse(NovoOrcamentoException e) {
        return Response.status(422)
                .entity(new ApiResponse("", "Error", e.getMessage()))
                .build();
    }

}
