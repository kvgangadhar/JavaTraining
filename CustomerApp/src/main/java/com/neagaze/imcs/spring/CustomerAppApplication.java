package com.neagaze.imcs.spring;

import com.neagaze.imcs.db.entities.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EntityScan(basePackages = {"com.neagaze.imcs.db"})
public class CustomerAppApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CustomerAppApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerAppApplication.class, args);
	}
}
