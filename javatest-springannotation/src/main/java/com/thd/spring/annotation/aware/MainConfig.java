package com.thd.spring.annotation.aware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@Configuration 告诉spring这是一个配置类相当于传统xml配置文件
@Configuration
@ComponentScan
@PropertySource("classpath:com/thd/spring/annotation/aware/config.properties")
public class MainConfig {
	@Bean
	public Animal animal(){
		return new Animal();
	}
}
