package com.thd.thread.methodlock.t03;

public class Operate implements Runnable{
	private Creator ctor ;
	private String name;
	public Operate(String name) {
		this.name  = name;
	}
	public void run() {
		System.out.println(this.name + " create ");
		this.ctor = Creator.getInstance();
		System.out.println(this.ctor);
	}
}
