package com.thd.spring.ioc.webframe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thd.spring.loadcfg.TestBeanA;

public class Test {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/ioc/webframe/applicationContext.xml");
		A a = new A("A");
		B b = new B("B");
		
		ServiceA serviceA = (ServiceA)factory.getBean("serviceA");
		serviceA.saveA(a);
		serviceA.saveB(b);
		System.out.println("===================");
		
		ServiceB serviceB = (ServiceB) factory.getBean("serviceB");
		serviceB.saveA(a);
		serviceB.saveB(b);
		
		System.out.println("===================");
		
		ServiceFactory serviceFactory = (ServiceFactory)factory.getBean("serviceFactory");
		serviceFactory.getServiceA().saveA(a);
		serviceFactory.getServiceA().saveB(b);
		serviceFactory.getServiceB().saveA(a);
		serviceFactory.getServiceB().saveB(b);
		
	}
}
