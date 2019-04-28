package com.thd.thread.interview.test03;

import java.util.concurrent.CountDownLatch;

public class LastWorkers implements Runnable {
	
	private CountDownLatch ct ;
	public LastWorkers(CountDownLatch ct){
		this.ct = ct;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ":Start");
		try {
			//计数器等待,如果计数器的值是0则会往下执行 , 执行ct.countDown()后会-1
			ct.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + ": Last Work Finish");

	}

}
