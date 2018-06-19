/** 
 * Class Description:########
 * Date : 2018年4月4日 上午10:06:16
 * Auth : ccse 
*/  

package com.thd.jvm.gc.refreneceType;

public class User {
	private String name;
	private int age ;
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
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}
