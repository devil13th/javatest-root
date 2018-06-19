package com.thd.spring.aop.configuration.example01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ClientTest {
	private ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/aop/configuration/example01/applicationContext-aop.xml");
	UserManager manager = (UserManager) factory.getBean("userManager");
	@Test
	public void test01() {
		System.out.println(manager);
		User u = manager.saveUser(new User("u","p"));
		System.out.println(u.getUser());
		System.out.println(u.getPwd());
	}
}
