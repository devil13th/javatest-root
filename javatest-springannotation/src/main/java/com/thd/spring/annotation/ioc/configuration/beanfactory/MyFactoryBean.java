package com.thd.spring.annotation.ioc.configuration.beanfactory;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Person> {

	public Person getObject() throws Exception {
		Person p = new Person();
		p.setName("person");
		return p;
	}

	public Class<?> getObjectType() {
		return Person.class;
	}

	public boolean isSingleton() {
		return true;
	}
	
}
