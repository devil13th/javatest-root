package com.thd.thread.api.t02sleep.t02;

public class Test02 {

	public static void main(String[] args) {
		SleepClass sc = new SleepClass();
		Thread t = new Thread(sc);
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.interrupt();
		System.out.println("main end ...");

	}

}


class SleepClass implements Runnable{

	@Override
	public void run() {
		System.out.println("sleep thread begin");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("be waked up !");
			e.printStackTrace();
		}
		System.out.println("sleep thread end");
	}
	
}