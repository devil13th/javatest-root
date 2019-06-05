package com.thd.spring.annotation.ioc.di.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service(value="bookService")
public class BookService {
	//如果有多个Bean都是BookDao类型则会找注释中带有@Primary注释的Bean
	@Autowired
	private BookDao bookDao;
	public String toString(){
		return "bookservice:" + bookDao.toString();
	}
	
}
