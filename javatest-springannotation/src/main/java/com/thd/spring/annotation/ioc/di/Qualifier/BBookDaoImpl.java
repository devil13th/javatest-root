package com.thd.spring.annotation.ioc.di.Qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
@Repository(value="bBookDaoImpl")
public class BBookDaoImpl implements BookDao {
	private String name = "BBookDaoImpl";;

	public String toString() {
		return "B BookDao [name=" + name + "]";
	}

	public BBookDaoImpl() {
		super();
	}
}
