package com.thd.thread.interview.test03;

import java.util.concurrent.CountDownLatch;


public class NormalWorkers implements Runnable {
	
	private CountDownLatch ct ;
	public NormalWorkers(CountDownLatch ct){
		this.ct = ct;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ":Start");
		
		for(int i = 0 , j = 100 ; i < j ; i++){
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
		//计数器-1
		ct.countDown();
		System.out.println(Thread.currentThread().getName() + " Finish ");

	}

}
