package fr.zzltxla.deploy_books.ws.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.jakarta.rs.base.JsonParseExceptionMapper;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CustomJsonParseExceptionMapper extends JsonParseExceptionMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomJsonParseExceptionMapper.class);

    @Override 
    public Response toResponse(JsonParseException exception) {
        String message = exception.getMessage();

        try {
            if (message != null) {
                message = (message.substring(0, message.indexOf("["))).trim();

                if (message.endsWith("at")) {
                    message = (message.substring(0, message.length() - 3));
                }
            } 

            LOGGER.error("Le JSON en entrée est incorrect ::" + exception.getMessage(), exception);
            return Response.status(422)
                .entity(new ParsingError("9999", "Invalid JSON input : Exception mesage is [" + message + "]"))
                .type(MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            LOGGER.error("Le JSON en entrée est incorrect :: + ", exception.getMessage(), exception);
            return Response
                .status(422)
                .entity(new ParsingError("9999", "Invalid JSON Input : Exception message is [" + exception.getMessage() + "]")).type(MediaType.APPLICATION_JSON).build();
        }
    }

    public class ParsingError {
        private String errorCode;
        private String errorMessage;

        public ParsingError(String errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode (String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage (String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}