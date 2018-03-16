package com.nwm.springbootweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootWebApplication extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootWebApplication.class);
	
	public static void main(String[] args) {
		logger.info("********** Starting the motherfucking spring boot app **********");
		SpringApplication.run(SpringBootWebApplication.class, args);
	}
//	
//	@Override
//	protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
//		return application.sources(SpringBootWebApplication.class);
//	}
}