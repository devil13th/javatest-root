package com.thd.thread.classlock.t01;

public class Lock {
	private int i = 20;
    public void begin() {
    	
    	synchronized(this.getClass()) {
			while(i > 0 ) {
				i--;
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
    	}
	}
}
