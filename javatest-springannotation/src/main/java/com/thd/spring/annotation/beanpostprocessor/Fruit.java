package com.thd.spring.annotation.beanpostprocessor;

import org.springframework.stereotype.Component;
@Component
@MyAnnotation(transferTo="com.thd.spring.annotation.beanpostprocessor.Animal")
public class Fruit {
	private String name = "Fruit";
	private int age = 1;
	
	public Fruit(){
		System.out.println(" Fruit构造 ");
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
		return "Fruit [name=" + name + ", age=" + age + "]";
	}
}
