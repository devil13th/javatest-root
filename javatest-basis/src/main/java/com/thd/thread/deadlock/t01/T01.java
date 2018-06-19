package com.thd.thread.deadlock.t01;

public class T01 {

	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		Tradeing tr1 = new Tradeing(obj1,obj2);
		Tradeing tr2 = new Tradeing(obj2,obj1);
		
		Thread t1 = new Thread(tr1);
		Thread t2 = new Thread(tr2);
		
		t1.start();
		t2.start();
	}

}
