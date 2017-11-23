package com.neagaze.imcs.spring.config;

import com.neagaze.imcs.db.service.ConcreteDbService;
import com.neagaze.imcs.db.service.DatabaseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by neaGaze on 11/18/17.
 */
@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private Environment env;

    public String readProperty() {
        return env.getProperty("target.url");
    }
}