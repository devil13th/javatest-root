package com.thd.spring.annotation.ioc.lifecycle.test02;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
//@Lazy
@Component
public class Animal implements InitializingBean,DisposableBean{
	
	private String name = "Animal";
	private int age = 1;
	
	public void afterPropertiesSet() throws Exception {
		System.out.println(" Animal afterPropertiesSet 方法执行 ");
	}
	public void destroy() throws Exception {
		System.out.println(" Animal destroy 方法执行 ");
		
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
