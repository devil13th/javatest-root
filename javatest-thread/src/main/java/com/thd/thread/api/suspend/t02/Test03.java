package com.thd.thread.api.suspend.t02;

public class Test03 {

	public static void main(String[] args) throws InterruptedException {
		SynchronizedObject obj = new SynchronizedObject();
		MyThread t1 = new MyThread(obj);
		MyThread t2 = new MyThread(obj);
		
		Thread threadA = new Thread(t1,"a");
		Thread threadB = new Thread(t2,"b");
		
		threadA.start();
		Thread.sleep(1000);
		threadB.start();
		
		Thread.sleep(1000);
		System.out.println(threadA.getName() + " 恢复了执行 ... 锁也正常的释放了");
		threadA.resume();
		
	}
	
	/*
	 * 运行结果
a begin ... 
a 用suspend()方法暂停了当前线程，并没有释放锁
a 恢复了执行 ... 锁也正常的释放了
a end ... 
b begin ... 
b end ... 

	 * 
	 * a线程调用suspend()方法后并不释放锁,
	 * 所以b线程不能进入到SynchronizedObject.pringString()方法，
	 * 线程被锁住了
	 */

}
