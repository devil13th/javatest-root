package com.thd.thread.api.t10join.t01;

import java.util.Map;
import java.util.Random;

public class ThreadA implements Runnable {
	private int waitTime;
	private Map<String,Integer> ct;
	public ThreadA(int waitTime,Map<String,Integer> ct){
		this.waitTime = waitTime;
		this.ct = ct;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(this.waitTime);
			ct.put(Thread.currentThread().getName(),new Random().nextInt(5));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
