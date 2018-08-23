package com.thd.springboot.iocimport.test01;

import org.springframework.stereotype.Component;

@Component
public class BeanF {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
