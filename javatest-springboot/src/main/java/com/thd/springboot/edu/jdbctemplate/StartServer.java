package com.thd.springboot.edu.jdbctemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource("classpath:com/thd/springboot/edu/jdbctemplate/server.properties") 
//@PropertySource(value={"classpath:com/thd/springboot/edu/jdbctemplate/server.properties","classpath:com/thd/springboot/edu/jdbctemplate/db.properties"},encoding="utf-8") 
public class StartServer {

	
	public static void main(String[] args) {
		 SpringApplication.run(StartServer.class, args);
	}

}
