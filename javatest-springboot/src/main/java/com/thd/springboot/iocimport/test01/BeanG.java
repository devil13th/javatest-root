package com.thd.springboot.iocimport.test01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanG {
	//普通字符串
	@Value("normal")
	private String str;
	
	@Value("${user.name}")
	private String name;
	
	@Value("${user.age}")
	private Integer age;
	
	@Value("${book.name}")
	private String bookName;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
}
