package com.thd.thread.api.t15inheritablethreadlocal;

public class ThreadParent implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " inheritableThreadLocal:" + Test.itl.get());
		System.out.println(Thread.currentThread().getName() + " threadLocal:" + Test.tl.get());
		Test.itl.set(Thread.currentThread().getName() + " 设置的 InheritableThreadLocal");
		Thread t1 = new Thread(new ThreadChild(),Thread.currentThread().getName() + " childA");
		Thread t2 = new Thread(new ThreadChild(),Thread.currentThread().getName() + " childB");
		
		t1.start();
		t2.start();
	}

}
