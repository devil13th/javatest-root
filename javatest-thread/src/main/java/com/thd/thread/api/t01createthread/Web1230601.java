package com.thd.thread.api.t01createthread;

public class Web1230601 implements Runnable{
	private int ticketCount = 100;

	@Override
	public void run() {
		for(int i = ticketCount ; i > 0 ; i--) {
			System.out.println(Thread.currentThread().getName() + "抢到第[" + i + "]张票");
		}
	}
	
}
