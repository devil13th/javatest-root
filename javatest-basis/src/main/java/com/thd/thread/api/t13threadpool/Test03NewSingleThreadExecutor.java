package com.thd.thread.api.t13threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test03NewSingleThreadExecutor {
	/**
	 * 创建一个顺序执行的线程池newSingleThreadExecutor
	 * 该线程中的线程顺序执行first in  first out 
	 * 始终只有最多1个线程再执行
	 */
	public static void main(String[] args) {
		
		ExecutorService es = Executors.newSingleThreadExecutor();
		
		for(int i = 0 , j = 18 ; i < j ; i++){
			Thread t = new Thread(new Thread01(i),"thread" + i);
			es.execute(t);
		}

	}

}
