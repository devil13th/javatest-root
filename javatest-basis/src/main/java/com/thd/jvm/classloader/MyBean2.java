package com.thd.jvm.classloader;

public class MyBean2 {
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

	public MyBean2(String name) {
		super();
		this.name = name;
	}

	public MyBean2() {
		super();
	}

	public String toString(){
		return this.name;
	}
}
