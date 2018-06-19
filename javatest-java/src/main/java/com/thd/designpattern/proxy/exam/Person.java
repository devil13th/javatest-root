package com.thd.designpattern.proxy.exam;

public class Person implements Talk {
	private String name;
	private Integer age;
	
	public Person(){};
	public Person(String name,Integer age){
		this.name = name;
		this.age = age;
	}
	
	
	public void talk(String msg) {
		System.out.println(name + "说：" + msg);

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

}
