package com.thd.spring.ioc.annotation.exam03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/ioc/annotation/exam03/applicationContext.xml");
		Service s = (Service)factory.getBean("service");
		s.saveUsr();
		s.saveRole();
		s.saveFun();
	}
}
