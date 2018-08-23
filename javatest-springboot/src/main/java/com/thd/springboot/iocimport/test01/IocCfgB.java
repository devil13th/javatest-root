package com.thd.springboot.iocimport.test01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IocCfgB {
	@Bean
	public BeanC beanC(BeanD beanD){
		return new BeanC(beanD);
	}
	
	@Bean
	public BeanD beanD(){
		return new BeanD();
	}
}
