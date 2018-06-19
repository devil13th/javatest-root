package com.thd.thread.methodlock.t03;

public class Creator {
	private static Creator instance;
	private Creator() {}
	
	public static Creator getInstance() {
		if(instance == null) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			instance = new Creator();
		}
		return instance;
	}
}
