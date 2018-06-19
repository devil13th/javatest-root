package com.thd.thread.api.suspend.t03;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		SuspendExample se = new SuspendExample();
		se.setName("xxxxxxxxx");
		se.start();
		Thread.sleep(2);
		se.suspend();
		System.out.println("end");
		
	}
	/*
	 * 最终并没有打印 "end" , 因为 System.out.println是同步方法，
	 * se调用suspend()方法暂停时会抱着锁没有释放，所以最后System.out.println("end")得不到锁，不能执行
	 */
}
