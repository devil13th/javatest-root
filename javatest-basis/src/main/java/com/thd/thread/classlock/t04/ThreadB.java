package com.thd.thread.classlock.t04;

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
