package com.thd.thread.api.t13threadpool;

import java.util.concurrent.Callable;

public class Thread03 implements Callable<String> {
	private int name;
	private int sleepTime;
	public Thread03(int sleepTime){
		this.sleepTime = sleepTime;
	}
	@Override
	public String call() {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Thread.currentThread().getName();

	}

}
