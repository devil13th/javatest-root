package com.thd.thread.api.t06interrupt;

public class Web1230606a extends Thread{
	private int ticketCount = 3;

	@Override
	public void run() {
		while(ticketCount>0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("InterruptedException异常!!!!" +Thread.currentThread().getName() + " 正在sleep时被interrupt(),或被interrpt()后进入sleep状态,停止sleep并清除中断标记");
			}
			
			//Thread.currentThread().interrupt();
			System.out.println(Thread.currentThread().getName() + "抢到第[" + ticketCount + "]张票");
			ticketCount--;
			System.out.println("当前线程(" + Thread.currentThread().getName() + ")是否已被中断:" +  Thread.currentThread().isInterrupted());

		}
	}
	
}
