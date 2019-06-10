package com.thd.spring.annotation.ioc.registbean.other;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Component(value="otherPackageBean")
public class OtherPackageBean {
	private String name = "thd";
	private int age = 5;
	
	public OtherPackageBean() {
		super();
		System.out.println(" OtherPackageBean构造 ");
	}
	public OtherPackageBean(String name, int age) {
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
