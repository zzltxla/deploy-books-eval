/**
 * 
 */
package fr.zzltxla.deploy_books.ws.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

/**
 * 
 * @author zzltxla
 *
 */
public class HttpStatusValidator {

    private static final Logger        LOGGER = LoggerFactory.getLogger(HttpStatusValidator.class);

    /**
     * Méthode qui controle si un code est bien un code http
     * 
     * @param elem
     *            - l'élément à controler
     * 
     * @return true ou false
     * 
     */
    public static boolean isStatusCode(String elem) {
        boolean ret = false;
        Status code = null;

        if (StringUtils.isNotEmpty(elem) && StringUtils.isNumeric(elem)) {
            code = Response.Status.fromStatusCode(Integer.valueOf(elem));
            if (code != null) {
                ret = true;
            } else {
                ret = false;
            }
        } else {
            ret = false;
        }
        return ret;
    }

    public static Status convertToStatusCode(String elem) {
        Status code = null;

        if (isStatusCode(elem)) {
            code = Response.Status.fromStatusCode(Integer.valueOf(elem));
            LOGGER.info("{} / {}", code.getStatusCode(), code.getReasonPhrase());
        }

        return code;
    }

}
