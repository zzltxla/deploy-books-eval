/**
 * 
 */
package fr.zzltxla.deploy_books.ws.service;

import java.util.Locale;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import fr.zzltxla.deploy_books.exception.ServiceFailedException;

public class BaseService {

    protected static final Logger     LOGGER                            = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    protected MessageSource           messageSource;

    @Autowired
    protected Properties              properties;

    protected Locale getLocale(String lang) {
        return Locale.of(lang.substring(0, 2), lang.substring(3, 5));
    }

    protected String getProperty(String key) {
        if (!properties.containsKey(key)) {
            LOGGER.error("Unknown property: " + key);
            throw new ServiceFailedException();
        }
        return properties.getProperty(key);
    }

    protected String getLabel(String labelField, String lang) {
        String label = messageSource.getMessage(labelField, null, getLocale(lang));
        return label;
    }

}
