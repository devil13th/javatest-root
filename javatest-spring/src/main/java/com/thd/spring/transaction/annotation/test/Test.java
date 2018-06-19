package com.thd.spring.transaction.annotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thd.spring.transaction.annotation.dao.BaseDao;
import com.thd.spring.transaction.annotation.pojo.Product;
import com.thd.spring.transaction.annotation.service.ProductService;
import com.thd.spring.transaction.annotation.service.SortService;

public class Test {

	public static void main(String[] args)  throws Exception {
		ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/transaction/annotation/resource/appContext-*.xml");
		System.out.println(factory);
		ProductService ps = (ProductService)factory.getBean("productServiceImpl");
		SortService ss = (SortService)factory.getBean("sortServiceImpl");
		BaseDao dao = (BaseDao)factory.getBean("dao");
		
		System.out.println(ps);
		System.out.println(ss);
		System.out.println(dao);
		
		//清除数据
		//ps.deleteAllProduct();
		//ss.deleteAllSort();
		
		Product p = new Product();
		p.setProName("产品");
		p.setSortId("1111");
		ps.saveProduct(p);
	} 

}
