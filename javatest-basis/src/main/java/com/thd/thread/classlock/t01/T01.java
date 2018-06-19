package com.thd.thread.classlock.t01;

public class T01 {
	public static void main(String[] args) {
		int z = 3;
		
		for(int i = 0 ; i < 3 ; i++) {
			Lock lk = new Lock();
			Perform pf = new Perform(lk);
			Thread t = new Thread(pf);
			System.out.println("创建线程:" + i);
			t.start();
		}
	}
	
	
}
