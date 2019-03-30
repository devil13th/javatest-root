package com.thd.thread.api.t12threadlocal.threadlocal;

public class T01 {

	public static void main(String[] args) {
		Thread01 t01 = new Thread01();
		Thread01 t02 = new Thread01();
		Thread t1 = new Thread(t01,"t1");
		Thread t2 = new Thread(t02,"t2");
		
		t1.start();
		t2.start();

	}

}
