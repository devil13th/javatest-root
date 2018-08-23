package com.thd.springboot.iocimport.test01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanE {
	@Autowired
	private BeanF beanF;

	public BeanF getBeanF() {
		return beanF;
	}

	public void setBeanF(BeanF beanF) {
		this.beanF = beanF;
	}

	
}
