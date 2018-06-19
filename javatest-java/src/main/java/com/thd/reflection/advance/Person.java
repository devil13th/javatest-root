package com.thd.reflection.advance;

public class Person {
	private String name;
	private Integer age;
	private Person son;
	
	public Person(String name,Integer age,Person son){
		this.name = name;
		this.age = age;
		this.son = son;
	}
	
	public Person(){}
	
	public Person(String name,Integer age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Person getSon() {
		return son;
	}
	public void setSon(Person son) {
		this.son = son;
	}
}
