package com.thd.spring.annotation.ioc.di.Qualifier;

import org.springframework.stereotype.Repository;

@Repository(value="aBookDaoImpl")
public class ABookDaoImpl implements BookDao{
	private String name = "ABookDaoImpl";

	public String toString() {
		return "A BookDao [name=" + name + "]";
	}

	public ABookDaoImpl() {
		super();
	}
}
