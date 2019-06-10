package com.thd.spring.annotation.ioc.configproperties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration

//设置外部配置文件的位置
@PropertySource("classpath:com/thd/spring/annotation/ioc/configproperties/config.properties")
public class MainConfig {
	@Bean
	public Animal animal(){
		return new Animal();
	}
}
