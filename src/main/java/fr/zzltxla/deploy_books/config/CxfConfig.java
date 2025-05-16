/**
 * 
 **/ 
package fr.zzltxla.deploy_books.config;


import org.apache.cxf.transport.servlet.CXFServlet;
import org.apache.cxf.version.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "/applicationContext-cxf.xml" })
public class CxfConfig {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CxfConfig.class);

    @Bean
    public ServletRegistrationBean<CXFServlet> cxfServlet() {
        LOGGER.info("Configuring {} Servlet", Version.getCompleteVersionString());
        CXFServlet servlet = new CXFServlet();
        return new ServletRegistrationBean<CXFServlet>(servlet, "/services/*");
    }

}
