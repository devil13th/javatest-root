package com.thd.thread.api.t03threadsafety.t01;

public class Web1230603 extends Thread{
	private int ticketCount = 10;
	
	/**
	 * 不使用同步,有可能运行到ticketCount--;这句之前被切换到其他线程了
	 * 所以ticketCount就是一个竞争的资源
	 * System.out.println和ticketCount--;应该是粒子性操作,这两句执行时不应该有其他进程执行这两句
	 */
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
