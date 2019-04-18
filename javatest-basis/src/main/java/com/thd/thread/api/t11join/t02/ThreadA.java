package com.thd.thread.api.t11join.t02;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

public class ThreadA implements Callable<Integer> {
	private int waitTime;
	private Map<String,Integer> ct;
	public ThreadA(int waitTime,Map<String,Integer> ct){
		this.waitTime = waitTime;
		this.ct = ct;
	}
	@Override
	public Integer call() throws Exception {
		Integer r = 0;
		try {
			Thread.sleep(this.waitTime);
			r = new Random().nextInt(5);
			System.out.println(Thread.currentThread().getName() + ":[" + this.waitTime + "] : " + r);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	

}
