package com.thd.spring.annotation.ioc.configproperties;

import org.springframework.beans.factory.annotation.Value;
//@Lazy
public class Animal {
	@Value("${name}")
	private String name = "Animal";
	
	@Value("${age}")
	private int age = 1;
	@Value("no_01")
	private String no;
	private String type;
	private String color;
	
	
	
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
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}
