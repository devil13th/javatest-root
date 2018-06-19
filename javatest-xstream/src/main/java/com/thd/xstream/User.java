package com.thd.xstream;

public class User {
	private  String name;  
    private int age;  
    private String sex;
    private String mes;
    private IdCard card;
    public IdCard getCard() {
		return card;
	}
	public void setCard(IdCard card) {
		this.card = card;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName(){  
        return name;  
    }  
    public int getAge(){  
        return age;  
    }  
    public void setName(String name){  
        this.name = name;  
    }  
    public void setAge(int age){  
        this.age = age;  
    }  
}
