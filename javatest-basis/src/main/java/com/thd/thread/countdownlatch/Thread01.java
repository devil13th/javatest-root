package com.thd.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Thread01 implements Runnable {
	
	private CountDownLatch cdl;
	public Thread01(CountDownLatch cdl){
		this.cdl = cdl;
	}
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " run ...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cdl.countDown();

	}

}
