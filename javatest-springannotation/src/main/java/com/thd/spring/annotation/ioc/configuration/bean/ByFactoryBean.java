package com.thd.spring.annotation.ioc.configuration.bean;

public class ByFactoryBean {
	private String name = "ByFactoryBean";
	private int age = 1;
	
	public ByFactoryBean(){
		System.out.println(" ByFactoryBean构造 ");
	}
	public ByFactoryBean(String name, int age) {
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
