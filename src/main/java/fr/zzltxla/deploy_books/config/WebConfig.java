/**
 * 
 **/ 
package fr.zzltxla.deploy_books.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author zzltxla
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);

    @Value("${deploys_books.url}")
    public String PARAM_DEPLOY_BOOKS_URL;


    @Override 
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        LOGGER.info("addResourceHandlers <- ()");

        registry.addResourceHandler("/*/*/index.html*", PARAM_DEPLOY_BOOKS_URL + "/index.html*")
                .addResourceLocations("classpath:/static/").setCacheControl(CacheControl.noStore());
        registry.addResourceHandler(PARAM_DEPLOY_BOOKS_URL + "/*/*", "/*/*")
                .addResourceLocations("classpath:/static/");

        LOGGER.info("addResourceHandlers -> ()");
    }


}
