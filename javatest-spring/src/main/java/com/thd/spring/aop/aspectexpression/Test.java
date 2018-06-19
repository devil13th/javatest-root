package com.thd.spring.aop.aspectexpression;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thd.spring.aop.aspectexpression.testa.UserService01;


public class Test extends TestCase {
	Logger log = Logger.getLogger(this.getClass());
	protected void setUp() throws Exception {
		log.info("---------------------------tester set up----------------------------- ");
		super.setUp();
	}
	
	public void test01(){
		log.info("test01");
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/aop/aspectexpression/spring-aop.xml");
		UserService service = (UserService) factory.getBean("userService");
		User u = new User();
		u.setUser("devil13th");
		u.setPwd("123456");
		User u2 = service.saveUser(u);
		log.info(service);
	}
	
	public void test02() throws Exception{
		log.info("test02");
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/aop/aspectexpression/spring-aop.xml");
		UserService01 service = (UserService01) factory.getBean("userService01");
		User u = new User();
		u.setUser("devil13th");
		u.setPwd("1234567");
		User u2 = service.updateUser(u);
		System.out.println("finish...");
	}

	protected void tearDown() throws Exception {
		log.info("---------------------------tester tear down---------------------------");
		super.tearDown();
	}
}
