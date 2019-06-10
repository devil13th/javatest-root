package com.thd.spring.annotation.ioc.registbean.test02imports.importconfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		//用配置类文件构建ApplicationContext,将配置类传入
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		System.out.println("-----------IOC 容器初始化完成------------");
		System.out.println(" ---------------- IOC中的Ben -------------");
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for(String name : beanNames){
			System.out.println(name);
		}
	}

}
