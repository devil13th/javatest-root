package com.thd.spring.jdbctemplate;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.util.HtmlUtils;

public class Client {

	
	public static void main(String[] args) {
		/*ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:com/thd/spring/jdbctemplate/appContext-*.xml");
		System.out.println(factory);
		ProductDaoImpl dao = (ProductDaoImpl)factory.getBean("productDao");
		System.out.println(dao);
		//System.out.println("111");
		List l = dao.query("select * from product");
		System.out.println(l.size());
		for(Object obj : l){
			Map m = (Map)obj;
			System.out.println(m);
		}
		
		*/
		System.out.println(HtmlUtils.htmlEscape("<div>王磊μΦ</div>", "ISO-8859-1"));
		
		
	}

}
