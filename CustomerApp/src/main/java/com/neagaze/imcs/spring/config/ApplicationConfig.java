package com.neagaze.imcs.spring.config;

import com.neagaze.imcs.db.service.ConcreteDbService;
import com.neagaze.imcs.db.service.DatabaseServiceInterface;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by neaGaze on 11/18/17.
 */
@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter {

    @Bean
    public DatabaseServiceInterface configureDbService() {
        return new ConcreteDbService();
    }

}