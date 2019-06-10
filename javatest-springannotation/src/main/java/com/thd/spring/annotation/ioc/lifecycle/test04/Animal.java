package com.thd.spring.annotation.ioc.lifecycle.test04;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
//@Lazy
@Component
public class Animal implements BeanPostProcessor{
	
	private String name = "Animal";
	private int age = 1;
	
	

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(" Animal postProcessBeforeInitialization方法执行 ");
		
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println(" Animal postProcessAfterInitialization方法执行 ");
		return bean;
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
