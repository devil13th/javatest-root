package com.thd.spring.annotation.ioc.configuration.beanfactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Configuration 告诉spring这是一个配置类相当于传统xml配置文件
@Configuration


public class MainConfig {
	
	
	//如果@Bean返回的bean是FactoryBean接口的实现类,则向IOC注入的是该实现类实现方法返回的bean
	@Bean
	public MyFactoryBean person(){
		return new MyFactoryBean();
	}
}
