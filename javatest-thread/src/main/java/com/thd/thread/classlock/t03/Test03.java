package com.thd.thread.classlock.t03;

public class Test03 {

	public static void main(String[] args) {
		Service service = new Service();
		Thread a = new Thread(new ThreadA(service));
		Thread b = new Thread(new ThreadB(service));
		
		a.start();
		b.start();
		
		/**
		 * 运行结果如下：
		 * 线程[Thread-0] 在 [1524844138018] 进入了 printA()
	   	 * 线程[Thread-1] 在 [1524844138018] 进入了 printB()
		 * 线程[Thread-0] 在 [1524844141022] 离开了 printA()
		 * 线程[Thread-1] 在 [1524844141022] 离开了 printB()
		 * 
		 * 异步执行
		 * 因为Service的 synchronized public void printB()方法锁定的是service对象 ,
		 * Service的 synchronized public void printA()方法锁定的是Service类
		 */
	}

}
