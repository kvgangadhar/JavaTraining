package com.neagaze.imcs.db.config;

import com.neagaze.imcs.db.service.ConcreteDbService;
import com.neagaze.imcs.db.service.DatabaseServiceInterface;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

/**
 * Created by neaGaze on 11/21/17.
 */
@Configuration
public class AppConfiguration {

    @Bean
    public DatabaseServiceInterface configureDbService() {
        return new ConcreteDbService();
    }

}
