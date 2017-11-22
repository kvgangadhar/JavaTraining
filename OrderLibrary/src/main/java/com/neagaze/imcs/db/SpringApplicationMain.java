package com.neagaze.imcs.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by neaGaze on 11/21/17.
 */
@SpringBootApplication
public class SpringApplicationMain extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringApplicationMain.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationMain.class, args);
    }
}
