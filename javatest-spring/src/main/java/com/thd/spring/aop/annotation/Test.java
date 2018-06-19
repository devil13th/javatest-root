package com.thd.spring.aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/aop/annotation/applicationContext-aop.xml");
		MyService service = (MyService) factory.getBean("myServiceImpl");
		System.out.println(service);
		service.save("hello world");
	}

}
