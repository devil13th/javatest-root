package com.thd.spring.annotation.ioc.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

//@Configuration 告诉spring这是一个配置类相当于传统xml配置文件
@Configuration
public class MainConfig {
	//windows系统下才注册此类
	@Conditional({ConditionalWindows.class})
	@Bean(name="personBean")
	public Person person(){
		return new Person("devil13th",15);
	}
	
	//linux系统下才注册此类
	@Conditional({ConditionalLinux.class})
	@Bean(name="animal")
	public Animal animal(){
		return new Animal("animal",15);
	}
}
