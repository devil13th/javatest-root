package com.thd.java.bean;

public class User implements Comparable{
	
	public int compareTo(Object o) {
		User u = (User)o;
		return this.age > u.age ? 1 : this.age == u.age ? 0 : -1;
	}
	public User(String name,Integer age){
		this.name = name; 
		this.age = age;
	}
	private String name;
	private Integer age;
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
	
	public static void main(String args[]){
		User u1 = new User("张三",5);
		User u2 = new User("李四",3);
		System.out.println(u1.compareTo(u2));
	}
}
