package fr.zzltxla.deploy_books.ws.utils;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


public class CustomObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = 1L;

    public CustomObjectMapper() {
        super();
        super.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSSXXX"));
        this.registerModule(new JavaTimeModule());
    }
}