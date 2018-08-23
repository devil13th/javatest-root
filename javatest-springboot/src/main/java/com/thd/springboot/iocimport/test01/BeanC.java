package com.thd.springboot.iocimport.test01;

public class BeanC {
	private BeanD beanD;
	public BeanC(BeanD d){
		this.beanD = d;
	}
	public BeanD getBeanD() {
		return beanD;
	}

	public void setBeanD(BeanD beanD) {
		this.beanD = beanD;
	}
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
