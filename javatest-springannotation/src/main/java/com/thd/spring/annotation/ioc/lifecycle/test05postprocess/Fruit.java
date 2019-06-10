package com.thd.spring.annotation.ioc.lifecycle.test05postprocess;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
@Component
public class Fruit implements InitializingBean,DisposableBean{
	private String name = "Fruit";
	private int age = 1;
	
	public Fruit(){
		System.out.println(" Fruit构造 ");
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println(" Fruit afterPropertiesSet 方法执行 ");
	}
	public void destroy() throws Exception {
		System.out.println(" Fruit destroy 方法执行 ");
		
	}
	
	public Fruit(String name, int age) {
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
