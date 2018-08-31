package com.thd.thread.api.t07wait.t03;

public class Test02 {

	public static void main(String[] args) {
		Object obj = new Object();
		SleepClass sc = new SleepClass(obj);
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
	private Object obj ;
	public SleepClass(Object obj) {
		this.obj = obj;
	}
	@Override
	public void run() {
		synchronized(obj) {
			System.out.println("sleep thread begin");
			try {
				obj.wait(5000);
			} catch (InterruptedException e) {
				System.out.println("be waked up !");
				e.printStackTrace();
			}
			System.out.println("sleep thread end");
		}
	}
	
}