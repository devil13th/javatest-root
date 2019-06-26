package com.thd.thread.tt;

import java.util.concurrent.CountDownLatch;

public class Calculator implements Runnable {
	private long i;
	private CountDownLatch cdl ;
	public Calculator(long i,CountDownLatch cdl){
		this.i = i;
		this.cdl = cdl;
	}
	@Override
	public void run() {
		long btime = System.currentTimeMillis();
		long sum = 0;
		while(i > 0){
			sum += i;
			i--;
		}
		long etime = System.currentTimeMillis();
		System.out.println("=========" + (etime - btime));
		System.out.println(sum);
		cdl.countDown();
	}

}
