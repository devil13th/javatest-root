package com.thd.spring.aop.reg;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thd.spring.aop.configuration.example01.UserManager;

public class ClientTest {
	
	private ApplicationContext factory ;
	
	@Test
	public void test01(){
		factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/aop/reg/applicationContext-aop01.xml");
		Service sa = (Service) factory.getBean("serviceA");
		sa.save("sa");
	}
	
	@Test
	public void test02(){
		factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/aop/reg/applicationContext-aop02.xml");
		Service sb = (Service) factory.getBean("serviceB");
		sb.delete("sb");
	}
	
	@Test
	public void test03(){
		factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/aop/reg/applicationContext-aop03.xml");
		Service sb = (Service) factory.getBean("serviceB");
		sb.save("sb");
	}
	
	@Test
	public void test04(){
		factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/aop/reg/applicationContext-aop04.xml");
		Service sb = (Service) factory.getBean("serviceB");
		sb.save("sb");
	}
	
}
