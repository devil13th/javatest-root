package com.thd.spring.annotation.ioc.lifecycle.test05postprocess;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
public class Animal implements InitializingBean,DisposableBean{
	
	private String name = "Animal";
	private int age = 1;
	public void init(){
		System.out.println(" Animal init 方法执行 ");
	}
	
	public void destory(){
		System.out.println(" Animal destory 方法执行 ");
	}
	@PostConstruct
	public void postConstruct(){
		System.out.println(" Animal  postConstruct 方法执行 ");
	}
	@PreDestroy
	public void preDestroy(){
		System.out.println(" Animal preDestroy 方法执行 ");
	}
	//实现InitializingBean接口 
	public void afterPropertiesSet() throws Exception {
		System.out.println(" Animal afterPropertiesSet 方法执行 ");
	}
	//实现DisposableBean接口
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
