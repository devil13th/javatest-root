package com.thd.spring.ioc.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/ioc/base/applicationContext.xml");
		A a = (A)factory.getBean("a");
		B b = (B)factory.getBean("b");
		System.out.println(b.getA());
		System.out.println(a.getB());
	}

}
