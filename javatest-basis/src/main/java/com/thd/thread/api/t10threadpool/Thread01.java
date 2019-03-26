package com.thd.thread.api.t10threadpool;

public class Thread01 implements Runnable {
	private int name;
	public Thread01(int i){
		this.name = i;
	}
	@Override
	public void run() {
		for(int i = 0 , j = 10 ; i < j ; i++){
			System.out.println(Thread.currentThread().getName() + ":" + this.name + ":" + i);
		}

	}

}
