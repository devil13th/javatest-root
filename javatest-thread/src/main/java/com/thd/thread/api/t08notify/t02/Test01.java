package com.thd.thread.api.t08notify.t02;

public class Test01 {

	public static void main(String[] args) {
		Object obj = new Object();
		for(int i = 0 , j = 5 ; i < j ; i++) {
			ThreadA thread = new ThreadA(obj);
			Thread t = new Thread(thread,"thread-" + i);
			
			t.start();
			
		}
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(obj) {
//			obj.notify();
			obj.notifyAll();
			System.out.println("叫醒你们后我 main还没有放弃锁 ");
		}
	}

}

class ThreadA implements Runnable{
	private Object obj;
	public ThreadA(Object obj) {
		this.obj = obj;
	}
	public void run() {
		synchronized(obj) {
			System.out.println(Thread.currentThread().getName() + " begin...");
			try {
				obj.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " end...");
		}
	}
}