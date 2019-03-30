package com.thd.thread.api.t03threadsafety.t01;

public class Web1230603a extends Thread{
	private int ticketCount = 10;
	/**
	 * 通过synchronized关键字锁住了this对象
	 * 也就是把this对象上了锁,保证了System.out.println和ticketCount--;执行的粒子性,正常输出了
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
			synchronized(this){
				System.out.println(Thread.currentThread().getName() + "抢到第[" + ticketCount + "]张票");
				ticketCount--;
			}
		}
	}
	
}
