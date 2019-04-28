package com.thd.thread.interview.test02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LastWorkers implements Runnable {
	
	private Count ct;
	private int i;
	private ReentrantLock lk ;
	private Condition lastCondition;
	private Condition normalCondition;
	private Condition firstCondition;
	public LastWorkers(ReentrantLock lk,Condition lastCondition,Condition normalCondition,Condition firstCondition,Count ct,int i ){
		this.ct = ct;
		this.i = i;
		this.lk = lk;
		this.lastCondition = lastCondition;
		this.normalCondition = normalCondition;
		this.firstCondition = firstCondition;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ":Start");
		lk.lock();
		
			while(ct.getI() != i  || !ct.isStarted()){
				System.out.println(" 等待: " + ct.getI() + " -- " + i);
				try {
					lastCondition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			normalCondition.signalAll();
		lk.unlock();
		System.out.println(Thread.currentThread().getName() + ": Last Work Finish");

	}

}
