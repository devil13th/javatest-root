package com.thd.thread.concurrency.t01unthreadsafe.t02;

public class CountOperate implements Runnable {
	private String name;
	private Count01 ct;
	public CountOperate(String name,Count01 ct) {
		this.name = name;
		this.ct = ct;
	}
	@Override
	public void run() {
		this.ct.add(this.name);

	}

}
