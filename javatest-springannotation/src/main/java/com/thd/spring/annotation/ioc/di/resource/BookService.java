package com.thd.spring.annotation.ioc.di.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="bookService")
public class BookService {
	
	
	//按照属性名字aBookDaoImpl匹配所有类型是BookDao的Bean的id
	@Autowired
	private BookDao aBookDaoImpl;
	public String toString(){
		return "bookservice中的BookDao实例为:" + aBookDaoImpl.toString();
	}
}
