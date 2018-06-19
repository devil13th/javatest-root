package com.thd.spring.aop.configuration.example02;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test extends TestCase {
	Logger log = Logger.getLogger(this.getClass());
	protected void setUp() throws Exception {
		log.info("---------------------------tester set up----------------------------- ");
		super.setUp();
	}
	
	public void test01(){
		log.info("test01");
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/aop/configuration/example02/applicationContext-aop.xml");
		UserService service = (UserService) factory.getBean("userService");
		User u = new User();
		u.setUser("devil13th");
		u.setPwd("123456");
		User u2 = service.saveUser(u);
		log.info(service);
	}
	
	public void test02() throws Exception{
		log.info("test02");
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/aop/configuration/example02/applicationContext-aop.xml");
		UserService service = (UserService) factory.getBean("userService");
		User u = new User();
		u.setUser("devil13th");
		u.setPwd("123456");
		User u2 = service.updateUser(u);
		log.info(service);
	}

	protected void tearDown() throws Exception {
		log.info("---------------------------tester tear down---------------------------");
		super.tearDown();
	}
}
