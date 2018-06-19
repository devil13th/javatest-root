package com.thd.hibernate.spring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	private ApplicationContext factory = new ClassPathXmlApplicationContext("com/thd/hibernate/spring/applicationContext.xml");
	private IService service = (IService)factory.getBean("service");
	private Logger log = Logger.getLogger("com.thd");
	public void save(){
		log.debug("----------  begin  ----------");
		try{
			Usr u = new Usr();
			u.setNickname("nickName1111");
			u.setPwd("1234561111");
			u.setUsr("userName11111");
			service.saveUsr(u);
			log.debug("----------  success  ----------");
		}catch(Exception e){
			e.printStackTrace();
		}
		log.debug("----------  end  ----------");
	}
	
	public void query(){
		log.debug("----------  begin  ----------");
		try{
			List l = service.queryUsr("", "", "");
			System.out.println(l);
			log.debug("----------  success  ----------");
		}catch(Exception e){
			e.printStackTrace();
		}
		log.debug("----------  end  ----------");
	}
	
	public static void main(String[] args){
		Client c = new Client();
		//c.save();
		
		c.query();
	}
}
