package com.thd.spring.jdbctemplate;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductDaoImplTest {

	private ProductDaoImpl dao;
	
	@Before
	public void init(){
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/jdbctemplate/appContext-*.xml");
		System.out.println(factory);
		dao = (ProductDaoImpl)factory.getBean("productDao");
		//System.out.println(dao);
	}
	@Test
	public void testQuery() {
		//System.out.println("111");
		List l = dao.query("select * from product");
		System.out.println(l.size());
		for(Object obj : l){
			Map m = (Map)obj;
			System.out.println(m);
		}
	}
	@Test
	public void testInsert() {
		dao.insert();
		System.out.println("finish");
	}
	
}
