package com.thd.spring.annotation.ioc.aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
//@Lazy
public class Animal implements ApplicationContextAware,EnvironmentAware{
	
	private String name = "Animal";
	private int age = 1;
	
	
	
	private ApplicationContext applicationContext;
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("通过BeanPostProcess的实际应用获取applicationContext");
		this.applicationContext = applicationContext;
		
	}
	
	
	
	
	
	private Environment environment;
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
