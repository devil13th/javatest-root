package com.thd.thread.api.suspend.t02;

public class SynchronizedObject {
	synchronized public void pringString() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println(currentThreadName + " begin ... ");
		if(currentThreadName.equals("a")){
			System.out.println(currentThreadName + " 用suspend()方法暂停了当前线程，并没有释放锁");
			Thread.currentThread().suspend();
		}
		System.out.println(currentThreadName + " end ... ");
	}
}
