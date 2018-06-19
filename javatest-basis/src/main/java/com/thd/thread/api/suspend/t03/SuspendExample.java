package com.thd.thread.api.suspend.t03;

public class SuspendExample extends Thread{
	private long i = 0;
	public void run() {
		while(true) {
			i++;
			System.out.println(i);
		}
	}
}
