package com.thd.thread.methodlock.t05;

public class Creator {
	private static Creator instance;
	private Creator() {}
	
	public static Creator getInstance() {
		if(instance == null) {
			synchronized(Creator.class){
				if(instance == null) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					instance = new Creator();
				}
			}
		}
		return instance;
	}
}
