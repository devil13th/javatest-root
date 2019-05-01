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
			System.out.println(Thread.currentThread().getName() + " sleep : " + waitTime);
//			try {
//				Thread.sleep(this.waitTime);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			for(int i = 0 , j = 100 ; i < j ; i++){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "_" + i);
			}
			ct.put(Thread.currentThread().getName(),new Random().nextInt(5));
		
		

	}

}
