package com.thd.thread.api.t15inheritablethreadlocal;

public class ThreadChild implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " inheritableThreadLocal:" + Test.tl.get());
		System.out.println(Thread.currentThread().getName() + " threadLocal:" + Test.itl.get());
	}

}
