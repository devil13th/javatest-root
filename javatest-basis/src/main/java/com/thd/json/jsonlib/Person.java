package com.thd.json.jsonlib;

import java.util.Date;
import java.util.List;

public class Person {
	private String name;
	private Date birthday;
	private int sex;
	private Person father;
	private List<Person> childs;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public List<Person> getChilds() {
		return childs;
	}
	public void setChilds(List<Person> childs) {
		this.childs = childs;
	}
	public Person getFather() {
		return father;
	}
	public void setFather(Person father) {
		this.father = father;
	}
	
}
