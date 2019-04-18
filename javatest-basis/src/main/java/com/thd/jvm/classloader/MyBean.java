package com.thd.jvm.classloader;

public class MyBean {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void say(){

        System.out.println("Hello MyClassLoader");
    }
	private String name ;

	public MyBean(String name) {
		super();
		this.name = name;
	}

	public MyBean() {
		super();
	}

	public String toString(){
		return this.name;
	}
}
