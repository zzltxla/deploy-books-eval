package fr.zzltxla.deploy_books.ws.utils;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.apache.cxf.jaxrs.impl.WebApplicationExceptionMapper;

@Provider
public class CustomWebApplicationExceptionMapper extends WebApplicationExceptionMapper {

    @Override
    public Response toResponse(WebApplicationException ex) {
        Response originalResponse = super.toResponse(ex);

        // Example: Custom error message structure
        CustomErrorResponse customError = new CustomErrorResponse(
            originalResponse.getStatus(),
            ex.getMessage() != null ? ex.getMessage() : "Unexpected error occurred",
            System.currentTimeMillis()
        );

        return Response
            .status(originalResponse.getStatus())
            .entity(customError)
            .type("application/json")
            .build();
    }

    // Inner class for JSON structure
    public static class CustomErrorResponse {
        private int status;
        private String message;
        private long timestamp;

        public CustomErrorResponse(int status, String message, long timestamp) {
            this.status = status;
            this.message = message;
            this.timestamp = timestamp;
        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }
}
