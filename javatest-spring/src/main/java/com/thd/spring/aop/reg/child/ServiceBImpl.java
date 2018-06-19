package com.thd.spring.aop.reg.child;

import com.thd.spring.aop.reg.Service;

public class ServiceBImpl implements Service {
	public void save(String str){
		System.out.println("serviceB: [save]"+str);
	}
	public void delete(String str){
		System.out.println("serviceB: [delete]"+str);
	}

}
