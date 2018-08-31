package com.thd.thread.methodlock.t02;

public class Count02 {

	synchronized public void add(String name) {
		try {
			System.out.println("method add +");
			for(int i = 0 , j = 4 ; i < j ; i++) {
				Thread.sleep(1000);
				if(i == 2) {
					int c = 1/0;
					System.out.println(c);
				}
				System.out.println(name + ":" + i);
			}
			System.out.println("method add -");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	
	synchronized public void divid(String name) {
		System.out.println("method divid +");
	}
}
