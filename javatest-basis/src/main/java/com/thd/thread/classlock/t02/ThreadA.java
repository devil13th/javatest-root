package com.thd.thread.classlock.t02;

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
