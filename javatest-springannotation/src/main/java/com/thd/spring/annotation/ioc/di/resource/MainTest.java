package com.thd.spring.annotation.ioc.di.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		BookService bs = (BookService)applicationContext.getBean("bookService");
		System.out.println(bs.toString());
		System.out.println(" ---------------- IOC中的Ben -------------");
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for(String name : beanNames){
			System.out.println(name);
		}
	}

}
