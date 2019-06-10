package com.thd.spring.annotation.ioc.lifecycle.test03;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
//@Lazy
@Component
public class Animal {
	private String name = "Animal";
	private int age = 1;
	
	public Animal(){
		System.out.println(" Animal构造方法执行 ");
	}
	@PostConstruct
	public void postConstruct(){
		System.out.println(" Animal  postConstruct 方法执行 ");
	}
	@PreDestroy
	public void preDestroy(){
		System.out.println(" Animal preDestroy 方法执行 ");
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
