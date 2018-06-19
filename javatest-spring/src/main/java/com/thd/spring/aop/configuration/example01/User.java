package com.thd.spring.aop.configuration.example01;

public class User {
	private String user;
	private String pwd;
	public User(String user,String pwd){
		this.pwd = pwd;
		this.user = user;
	}
	public String toString(){
		return "[" + this.user + "|" + this.pwd + "]";
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
