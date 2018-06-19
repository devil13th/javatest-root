package com.thd.spring.aop.annotation;

public class MyServiceImpl implements MyService {

	public void save(String str) {
		System.out.println("service.save():" + str);
	}

}
