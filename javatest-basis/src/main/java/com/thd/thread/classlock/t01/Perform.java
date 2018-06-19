package com.thd.thread.classlock.t01;

public class Perform implements Runnable {
	private Lock lk;
	public Perform(Lock lk) {
		this.lk = lk;
	}
	public void run() {
		lk.begin();
	}

}
