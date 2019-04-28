package com.thd.thread.interview.test02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FirstWorkers implements Runnable {
	
	private Count ct;
	private int i;
	private ReentrantLock lk ;
	private Condition lastCondition;
	private Condition normalCondition;
	private Condition firstCondition;
	public FirstWorkers(ReentrantLock lk,Condition lastCondition,Condition normalCondition,Condition firstCondition,Count ct,int i ){
		this.ct = ct;
		this.i = i;
		this.lk = lk;
		this.lastCondition = lastCondition;
		this.normalCondition = normalCondition;
		this.firstCondition = firstCondition;
	}
	
	@Override
	public void run() { 
		System.out.println(Thread.currentThread().getName() + ": First Worker Start");
		System.out.println("我是必须第一个执行的任务");
		ct.start();
		lk.lock();
			normalCondition.signalAll();
			lastCondition.signalAll();
		lk.unlock();
		System.out.println(Thread.currentThread().getName() + ": First Worker Finish");

	}

}
