package com.thd.reflection.basic;

public class User {
	private String name;
	private Integer age;
	
	
	
	
	public User(){}
	
	public User(String name){
		this.name = name;
	}
	
	public User(String name,Integer age) {
		this.name = name;
		this.age = age;
	};
	
	
	
	
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
