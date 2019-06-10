package com.thd.spring.annotation.ioc.registbean.test02imports.importselector;

public class Animal {
	private String name = "Animal";
	private int age = 1;
	
	public Animal(){
		System.out.println(" Animal构造 ");
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
