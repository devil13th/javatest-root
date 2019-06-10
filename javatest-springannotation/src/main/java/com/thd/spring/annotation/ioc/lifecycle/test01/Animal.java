package com.thd.spring.annotation.ioc.lifecycle.test01;


public class Animal {
	private String name = "Animal";
	private int age = 1;
	
	public Animal(){
		System.out.println(" Animal构造方法执行 ");
	}
	
	public void init(){
		System.out.println(" Animal init 方法执行 ");
	}
	
	public void destory(){
		System.out.println(" Animal destory 方法执行 ");
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
