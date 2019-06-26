package com.thd.thread.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Thread01 implements Runnable {
	
	private CyclicBarrier cb;
	private int sleepTime ;
	public Thread01(CyclicBarrier cb,int i){
		this.cb = cb;
		sleepTime = i*1000;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(sleepTime);
			System.out.println(Thread.currentThread().getName() + " 1 ...");
			cb.await();

			Thread.sleep(sleepTime);
			System.out.println(Thread.currentThread().getName() + " 2 ...");
			cb.await();
			

			Thread.sleep(sleepTime);
			System.out.println(Thread.currentThread().getName() + " 3 ...");
			cb.await();
			

			Thread.sleep(sleepTime);
			System.out.println(Thread.currentThread().getName() + " 4 ...");
			cb.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
