package com.thd.thread.methodlock.t01;

public class Count01 {

	synchronized public void add(String name) {
		try {
			System.out.println("method add +");
			Thread.sleep(3000);
			System.out.println("method add -");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	
	synchronized public void divid(String name) {
		System.out.println("method divid +");
	}
}
