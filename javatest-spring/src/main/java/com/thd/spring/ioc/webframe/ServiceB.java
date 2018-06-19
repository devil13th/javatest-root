package com.thd.spring.ioc.webframe;

public class ServiceB  extends BaseServiceImpl implements IService {
	public void saveB(B b){
		this.getPubDao().saveObj(b);
	}
	
	public void saveA(A a){
		this.getServiceFactory().getServiceA().saveA(a);
	}
}
