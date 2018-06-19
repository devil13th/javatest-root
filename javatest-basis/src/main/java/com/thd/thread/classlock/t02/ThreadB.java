package com.thd.thread.classlock.t02;

public class ThreadB implements Runnable {
	private Service service;
	public ThreadB(Service service) {
		this.service = service;
	}

	@Override
	public void run() {
		this.service.printB();

	}

}
