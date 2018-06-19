package com.thd.spring.ioc.annotation.exam02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/ioc/annotation/exam02/applicationContext.xml");
		UsrService service = (UsrService)factory.getBean("usrService");
		service.save();
	}
}
