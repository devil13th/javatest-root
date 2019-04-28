package com.thd.thread.interview.test01;

public class Worker implements Runnable {
	private Count ct ;
	public Worker(Count ct){
		this.ct = ct;
	}
	
	@Override
	public void run() {
		for(int i = 0  , j = 1000 ; i < j ; i++){
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
		synchronized(ct){
			ct.add();
			System.out.println(Thread.currentThread().getName() + " finish : " + ct.getI());
			ct.notifyAll();
		}
	}

}
