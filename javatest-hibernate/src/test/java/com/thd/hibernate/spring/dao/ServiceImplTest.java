package com.thd.hibernate.spring.dao;

import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceImplTest extends TestCase {
	private ApplicationContext factory = new ClassPathXmlApplicationContext("com/thd/hibernate/spring/applicationContext.xml");
	private IService service = (IService)factory.getBean("service");
	private Logger log = Logger.getLogger(this.getClass());
	public void testSave(){
		
		log.debug("----------  begin  ----------");
		try{
			Usr u = new Usr();
			u.setNickname("ʮ����1");
			u.setPwd("123456");
			u.setUsr("devil13th");
			service.saveUsr(u);
			log.debug("----------  success  ----------");
		}catch(Exception e){
			e.printStackTrace();
		}
		log.debug("----------  end  ----------");
		
		
	}
	
	
	public void testQuery(){
		log.debug("----------  begin  ----------");
		try{
			//防sql注入测试
			List l = service.queryUsr("%十三妖%","devil'dd",null);
			log.debug("结果数量：[" + l.size() + "]");
			System.out.println("---------------------------------------");
			List l2 = service.queryUsr("%十三妖%","",null);
			log.debug("结果数量：[" + l2.size() + "]");
			log.debug("----------  success  ----------");
		}catch(Exception e){
			e.printStackTrace();
		}
		log.debug("----------  end  ----------");
	}
}
