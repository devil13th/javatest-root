package com.thd.thread.syn.test02;

public class TestThread implements Runnable{
	
	private int i = 100;
	public static void main(String[] args){
		
		TestThread t = new TestThread();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
		new Thread(t).start();
	}
	public synchronized void run(){
		
		int x = i;
		x++;
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.getMessage();
		}
		i=x;
		System.out.println(Thread.currentThread().getName() + ":" + i);
	}
}
