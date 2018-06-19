package com.thd.spring.ioc.webframe;

public class ServiceA extends BaseServiceImpl implements IService {
	public void saveA(A a){
		this.getPubDao().saveObj(a);
	}
	
	public void saveB(B b){
		this.getServiceFactory().getServiceB().saveB(b);
	}
}
