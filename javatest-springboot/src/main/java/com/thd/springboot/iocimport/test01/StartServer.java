package com.thd.springboot.iocimport.test01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@Import({IocCfgA.class,IocCfgB.class})
@PropertySource({"classpath:com/thd/springboot/iocimport/test01/variable.properties","classpath:com/thd/springboot/iocimport/test01/variableB.properties"})
public class StartServer {
	public static void main(String[] args) {
		 SpringApplication.run(StartServer.class, args);
	}
}
