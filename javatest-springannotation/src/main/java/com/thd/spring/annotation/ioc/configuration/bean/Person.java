package com.thd.spring.annotation.ioc.configuration.bean;

public class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		super();
		System.out.println(" Person构造 ");
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
