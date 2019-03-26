package com.thd.thread.api.t10threadpool;

import java.util.concurrent.Callable;

public class Thread02 implements Callable<String> {
	private int name;
	public Thread02(int i){
		this.name = i;
	}
	@Override
	public String call() {
		for(int i = 0 , j = 10 ; i < j ; i++){
			System.out.println(Thread.currentThread().getName() + ":" + this.name + ":" + i);
		}
		return this.name + "完成";

	}

}
