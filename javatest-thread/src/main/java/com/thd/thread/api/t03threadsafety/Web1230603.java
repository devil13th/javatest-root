package com.thd.thread.api.t03threadsafety;

public class Web1230603 extends Thread{
	private int ticketCount = 10;

	@Override
	public void run() {
		while(ticketCount>0) {
			
			//为了效果明显,睡一下
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "抢到第[" + ticketCount + "]张票");
			ticketCount--;
		}
	}
	
}
