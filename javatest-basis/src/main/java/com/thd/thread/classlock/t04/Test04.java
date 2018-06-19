package com.thd.thread.classlock.t04;

public class Test04 {

	public static void main(String[] args) {
		Service service = new Service();
		Thread a = new Thread(new ThreadA(service));
		Thread b = new Thread(new ThreadB(service));
		
		a.start();
		b.start();
		
		/**
		 * 运行结果如下：
		 * 线程[Thread-0] 在 [1524844496262] 进入了 printA()
		 * 线程[Thread-0] 在 [1524844499264] 离开了 printA()
		 * 线程[Thread-1] 在 [1524844499264] 进入了 printB()
		 * 线程[Thread-1] 在 [1524844502267] 离开了 printB()
		 * 
		 * 异步执行
		 * 因为Service的 synchronized public void printA()方法锁定的是Service类方法
		 * 和printB()中的synchronized(Service.class)锁定的都是Service类
		 */
	}

}
