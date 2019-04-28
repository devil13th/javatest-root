package com.thd.thread.interview.test03;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Test03 {
	/**
	 * 使用 CountDownLatch 计数控制某个任务最后一个执行
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 10;
		//初始化一个计数器 总数为num
		CountDownLatch ct = new CountDownLatch(num);
		Runnable lastRn = new LastWorkers( ct );
		Thread lastThread = new Thread(lastRn,"Thread-last");
		lastThread.start();
		for(int i = 0 , j = num ; i < j ; i++){
			Runnable rn = new NormalWorkers(ct);
			Thread t = new Thread(rn,"Thread-" + i);
			t.start();
		}
		
	}

}
