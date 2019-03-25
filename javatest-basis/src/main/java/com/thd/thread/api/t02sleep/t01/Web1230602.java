package com.thd.thread.api.t02sleep.t01;

public class Web1230602 extends Thread{
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
			if(ticketCount == 5) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(" be waked up ");
					e.printStackTrace();
				}
			}
		}
	}
	
}
