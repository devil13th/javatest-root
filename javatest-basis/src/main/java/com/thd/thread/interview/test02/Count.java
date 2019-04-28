package com.thd.thread.interview.test02;

public class Count {
	private int i = 0;
	private boolean started = false;
	
	public boolean start(){
		this.started = true;
		return this.started;
	}
	public int add(){
		i++;
		return i;
	}
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	public boolean isStarted() {
		return started;
	}
	public void setStarted(boolean started) {
		this.started = started;
	}
	
}
