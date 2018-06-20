package com.thd.thread.api.t06interrupt;

public class Web1230606 extends Thread{
	private int ticketCount = 10;

	@Override
	public void run() {
		while(ticketCount>0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "抢到第[" + ticketCount + "]张票");
			ticketCount--;
				
		}
	}
	
}
