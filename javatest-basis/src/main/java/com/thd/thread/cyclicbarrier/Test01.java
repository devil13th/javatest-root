package com.thd.thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class Test01 {
	/**
	 * 通过它可以实现让一组线程等待至某个状态之后再全部同时执行
	 * 用来挂起当前线程，直至所有线程都到达barrier状态再同时执行后续任务
	 * 
	 * 叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用。
	 * 我们暂且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了
	 * 
	 * 类似于一个可以复用的countdownlatch,当计数减到0后重新进行计数
	 * @param args
	 */
	public static void main(String[] args) {
		int ct = 5 ;
		CyclicBarrier cd = new CyclicBarrier(ct);
		
		for(int i = 0 ; i < ct ; i++){
			Thread t = new Thread(new Thread01(cd,i%2));
			t.start();
		}
		
		
	}

}
