package com.thd.springboot.edu.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("classpath:com/thd/springboot/edu/properties/cfg.properties") 
@PropertySource(value={
		"classpath:com/thd/springboot/edu/properties/cfg.properties",
		"classpath:com/thd/springboot/edu/properties/author.properties"
		},encoding="utf-8") 
public class StartServer {

	
	public static void main(String[] args) {
		 SpringApplication.run(StartServer.class, args);
	}

}
