package com.thd.thread.objectlock.t02;

public class Test02 {

	public static void main(String[] args) {
		String a = "A";
		ThreadA ta = new ThreadA(a);
		Thread t1 = new Thread(ta);
		Thread t2 = new Thread(ta);
		t1.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("a=" + a);
		System.out.println("finish");
	}

}

class ThreadA implements Runnable{
	private String lock;
	public ThreadA(String lock) {
		this.lock = lock;
	}
	public void run() {
		synchronized(lock) {
			System.out.println(Thread.currentThread().getName() + " begin at " + System.currentTimeMillis());
			lock = "B";
			System.out.println("change lock = B");
			System.out.println(lock);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " end at " + System.currentTimeMillis());
		}
	}
	
	/*
运行结果如下：
Thread-0 begin at 1525014308893
change lock = B
B
Thread-1 begin at 1525014309896
change lock = B
B
Thread-0 end at 1525014311898
Thread-1 end at 1525014312897
a=A
finish

锁改变后有可能达不到同步的效果
	 */
}