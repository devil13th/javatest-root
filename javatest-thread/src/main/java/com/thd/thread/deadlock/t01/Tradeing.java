package com.thd.thread.deadlock.t01;

public class Tradeing implements Runnable {
	private Object money;
	private Object obj;
	public Tradeing(Object money,Object obj) {
		this.money = money;
		this.obj = obj;
	}
	@Override
	public void run() {
		System.out.print(Thread.currentThread().getName() + " begin tradeing ...");
		synchronized(this.money) {
			System.out.println(Thread.currentThread().getName() + " get money");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized(this.obj) {
				System.out.println(Thread.currentThread().getName() + " get obj");
				
				System.out.println(Thread.currentThread().getName() + " trade");
				
			}
			
		}
		System.out.print(Thread.currentThread().getName() + " finish tradeing ...");
		
	}

}
