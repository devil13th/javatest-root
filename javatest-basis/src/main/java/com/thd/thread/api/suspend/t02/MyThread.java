package com.thd.thread.api.suspend.t02;

public class MyThread implements Runnable{
	private SynchronizedObject synchronizedObject;
	public MyThread(SynchronizedObject synchronizedObject) {
		this.synchronizedObject = synchronizedObject;
	}
	public void run() {
		this.synchronizedObject.pringString();
	}
}
