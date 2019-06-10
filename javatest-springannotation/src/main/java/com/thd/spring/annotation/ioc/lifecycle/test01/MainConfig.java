package com.thd.spring.annotation.ioc.lifecycle.test01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

//@Configuration 告诉spring这是一个配置类相当于传统xml配置文件
@Configuration

public class MainConfig {
	//@Lazy
	//指定Bean初始化和销毁的方法
	@Bean(initMethod="init",destroyMethod="destory")
	public Animal animal(){
		return new Animal();
	}
}
