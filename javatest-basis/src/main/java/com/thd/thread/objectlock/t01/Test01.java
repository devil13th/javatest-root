package com.thd.thread.objectlock.t01;

public class Test01 {

	public static void main(String[] args) {
		Room rm = new Room();
		Study sy = new Study(rm);
		Work wk = new Work(rm);
		Thread t1 = new Thread(rm);
		Thread t2 = new Thread(sy);
		Thread t3 = new Thread(wk);
		t1.start();
		t2.start();
		t3.start();
		System.out.println("finish");
	}

}





