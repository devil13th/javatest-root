package com.thd.thread.api.t06interrupt;

public class Test06 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Web1230606(),"张三");
		t.start();
		
		Thread.sleep(100);
		//interrupt()并不能中断线程，而是做了一个暂停标记 执行interrupt后t进程仍然在输出
		t.interrupt();
		
		System.out.println(t.isInterrupted() + "------------");
		//可以通过Thread.isInterrupt()方法判断进程是否已打上中断标记

	}

}
