package com.thd.thread.methodlock.t02;

public class CountOperate implements Runnable {
	private String name;
	private Count02 ct;
	public CountOperate(String name,Count02 ct) {
		this.name = name;
		this.ct = ct;
	}
	@Override
	public void run() {
		if("a".equals(this.name)) {
			this.ct.add(this.name);
		}else {
			this.ct.divid(this.name);
		}
		
	}

}
