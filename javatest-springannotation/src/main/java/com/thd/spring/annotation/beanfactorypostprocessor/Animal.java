package com.thd.spring.annotation.beanfactorypostprocessor;

import org.springframework.stereotype.Component;

@Component
public class Animal {
	
	private String name = "Animal";
	private int age = 1;

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
		return "Animal [name=" + name + ", age=" + age + "]";
	}
	public String animalMethod(){
		System.out.println("animal method ...");
		return "animal method";
	}
}
