package com.thd.spring.annotation.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for(String name : beanNames){
			//System.out.println(name);
		}
		
		MathService service = (MathService)applicationContext.getBean("mathService");
		System.out.println(service);
		Integer i = service.add(1, 2);
		System.out.println(i);
		System.out.println("------------");
		Double x = service.div(5, 0);
		System.out.println(x);
		applicationContext.close();
	}

}
