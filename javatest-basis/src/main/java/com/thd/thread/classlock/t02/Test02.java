package com.thd.thread.classlock.t02;

public class Test02 {

	public static void main(String[] args) {
		Service service = new Service();
		Thread a = new Thread(new ThreadA(service));
		Thread b = new Thread(new ThreadB(service));
		
		a.start();
		b.start();
		
		/**
		 * 运行结果如下：
		 * 线程[Thread-0] 在 [1524844298403] 进入了 printA()
		 * 线程[Thread-0] 在 [1524844301405] 离开了 printA()
		 * 线程[Thread-1] 在 [1524844301406] 进入了 printB()
		 * 线程[Thread-1] 在 [1524844304411] 离开了 printB()
		 * 
		 * 同步执行
		 * 因为Service的 synchronized public void printA()方法锁定的是Service类
		 * 和Service的 synchronized public void printB()方法锁定的是Service类方法锁定的都是Service类
		 */
	}

}
