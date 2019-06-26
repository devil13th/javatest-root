package com.thd.spring.annotation.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
//@Lazy
public class Animal implements ApplicationContextAware,EnvironmentAware,BeanFactoryAware{
	
	private String name = "Animal";
	private int age = 1;
	
	
	
	private ApplicationContext applicationContext;
	//实现ApplicationContextAware接口来获取 applicationContext
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("通过BeanPostProcess的实际应用获取applicationContext");
		this.applicationContext = applicationContext;
		
	}
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	
	
	private BeanFactory beanFactory ;
	//实现BeanFactoryAware接口来获取beanFactory
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
	public BeanFactory getBeanFactory() {
		return beanFactory;
	}



	private Environment environment;
	//实现EnvironmentAware接口来获取environment
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	public Environment getEnvironment() {
		return environment;
	}
	
	
	
	public Animal(){
		System.out.println(" Animal构造方法执行 ");
	}
	
	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
