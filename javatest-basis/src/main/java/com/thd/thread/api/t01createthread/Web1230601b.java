package com.thd.thread.api.t01createthread;

import java.util.concurrent.Callable;

public class Web1230601b implements Callable<Integer>{
	private int ticketCount = 20;

	@Override
	public Integer call() throws Exception {
		int ct = 0;
		for(int i = ticketCount ; i > 0 ; i--) {
			System.out.println(Thread.currentThread().getName() + "抢到第[" + i + "]张票");
			ct++;
			Thread.sleep(100);
		}
		return ct;
	}
	
}
