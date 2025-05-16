/**
 * 
 **/ 
package fr.zzltxla.deploy_books.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * @author zzltxla
 *
 */
@Configuration
public class DatabaseConfig {

    @Bean(name = "dataSourceDashboard")
    @ConfigurationProperties(prefix = "dashboard.datasource")
    public DataSource dataSourceDashboard() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jdbcTemplateDashboard")
    public JdbcTemplate jdbcTemplateAuthn(@Qualifier("dataSourceDashboard") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
