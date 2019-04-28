package com.thd.thread.interview.test02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Test02 {
	/**
	 * 某个线程在其他线程执行之前执行 (Condition.await()方法实现)
	 * 某个线程在其他线程执行完后再执行 (Condition.await()方法实现)
	 * @param args
	 */
	public static void main(String[] args) {
		ReentrantLock lk = new ReentrantLock();
		Condition lastCondition = lk.newCondition();
		Condition normalCondition = lk.newCondition();
		Condition firstCondition = lk.newCondition();
		Count ct = new Count();
		
		int num = 10;
		
		Runnable lastRn = new LastWorkers( lk, lastCondition, normalCondition, firstCondition,ct, num );
		Thread lastThread = new Thread(lastRn,"Thread-last");
		lastThread.start();
		for(int i = 0 , j = num ; i < j ; i++){
			Runnable rn = new NormalWorkers(ct,lk,lastCondition,normalCondition,firstCondition);
			Thread t = new Thread(rn,"Thread-" + i);
			t.start();
		}
		
		Runnable firstRn = new FirstWorkers( lk, lastCondition, normalCondition,firstCondition, ct, num );
		Thread firstThread = new Thread(firstRn,"Thread-first");
		firstThread.start();

	}

}
