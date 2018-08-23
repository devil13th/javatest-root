package com.thd.springboot.iocimport.test01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IocCfgA {
	@Bean
	public BeanA beanA(){
		return new BeanA();
	}
	
	@Bean
	public BeanB beanB(){
		return new BeanB();
	}
}
