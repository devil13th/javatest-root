package com.thd.spring.ioc.webframe;

public class ServiceFactoryImpl implements ServiceFactory{
	private ServiceA serviceA;
	private ServiceB serviceB;
	public ServiceA getServiceA() {
		return serviceA;
	}
	public void setServiceA(ServiceA serviceA) {
		this.serviceA = serviceA;
	}
	public ServiceB getServiceB() {
		return serviceB;
	}
	public void setServiceB(ServiceB serviceB) {
		this.serviceB = serviceB;
	}
}
