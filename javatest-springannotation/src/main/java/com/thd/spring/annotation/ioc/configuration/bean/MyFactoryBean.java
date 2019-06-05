package com.thd.spring.annotation.ioc.configuration.bean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<ByFactoryBean> {

	public ByFactoryBean getObject() throws Exception {
		ByFactoryBean bfb = new ByFactoryBean();
		bfb.setName("by factory bean");
		return bfb;
	}

	public Class<?> getObjectType() {
		return ByFactoryBean.class;
	}

	public boolean isSingleton() {
		return true;
	}
	
}
