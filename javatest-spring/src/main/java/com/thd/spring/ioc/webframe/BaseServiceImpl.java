package com.thd.spring.ioc.webframe;

public class BaseServiceImpl {
	private ServiceFactory serviceFactory;
	private PubDao pubDao;
	public PubDao getPubDao() {
		return pubDao;
	}

	public void setPubDao(PubDao pubDao) {
		this.pubDao = pubDao;
	}

	public ServiceFactory getServiceFactory() {
		return serviceFactory;
	}

	public void setServiceFactory(ServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}
}
