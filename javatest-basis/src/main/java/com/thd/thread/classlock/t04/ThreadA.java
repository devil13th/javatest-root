package com.thd.thread.classlock.t04;

public class ThreadA implements Runnable {
	private Service service;
	public ThreadA(Service service) {
		this.service = service;
	}

	@Override
	public void run() {
		this.service.printA();

	}

}
