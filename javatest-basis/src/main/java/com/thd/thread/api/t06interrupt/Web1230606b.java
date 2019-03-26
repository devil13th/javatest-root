package com.thd.thread.api.t06interrupt;

public class Web1230606b extends Thread{
	private int ticketCount = 10;

	@Override
	public void run() {
		while(ticketCount>0) {
			if(!this.isInterrupted()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("catch InterruptedException 异常");
					break;
				}
				System.out.println(Thread.currentThread().getName() + "抢到第[" + ticketCount + "]张票");
				ticketCount--;
			}else{
				break;
			}
		}
		System.out.println("[" + ticketCount + "]");
	}
	
}
