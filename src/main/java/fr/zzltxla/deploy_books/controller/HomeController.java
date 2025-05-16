/**
 * 
 */
package fr.zzltxla.deploy_books.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 
 * @author zzltxla
 *
 */
@Controller
@RequestMapping("${deploys-books.url}")
public class HomeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Value("${deploys-books.url}")
    private String basePath;

    
    /**
     * Default constructor
     */
    public HomeController() {
        LOGGER.info("HomeController <- ()");
        LOGGER.info("Default constructor ... do nothing !!!");
        LOGGER.info("HomeController -> ()");
    }


    @GetMapping(value="/")
    public String home() {
        LOGGER.info("home <- ()");
        String ret = String.format("forward:%s/index.html", basePath);
        LOGGER.info("home -> () - return '{}'", ret);
        return ret;
    }

}
