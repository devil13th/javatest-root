package com.thd.spring.annotation.ioc.di.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="bookService")
public class BookService {
	
	//抛异常：expected single matching bean but found 2: ABookDaoImpl,BBookDaoImpl
//	@Autowired
//	private BookDao bookDao;
//	public String toString(){
//		return "bookservice:" + bookDao.toString();
//	}
	
	
	//如果有多个BookDao类型的Bean则按照属性名字aBookDaoImpl匹配所有类型是BookDao的Bean的id
	@Autowired
	private BookDao aBookDaoImpl;
	public String toString(){
		return "bookservice:" + aBookDaoImpl.toString();
	}
}
