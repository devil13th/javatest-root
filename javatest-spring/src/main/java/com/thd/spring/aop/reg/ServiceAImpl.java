package com.thd.spring.aop.reg;

public class ServiceAImpl implements Service {
	public void save(String str){
		System.out.println("serviceA: [save]"+str);
	}
	public void delete(String str){
		System.out.println("serviceA: [delete]"+str);
	}
}
