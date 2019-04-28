package com.thd.thread.interview.test02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class NormalWorkers implements Runnable {
	
	private Count ct ;
	private ReentrantLock lk;
	private Condition lastCondition;
	private Condition normalCondition;
	private Condition firstCondition;
	
	public NormalWorkers(Count ct,ReentrantLock lk,Condition lastCondition,Condition normalCondition,Condition firstCondition){
		this.ct = ct;
		this.lastCondition = lastCondition;
		this.normalCondition = normalCondition;
		this.lk = lk;
		this.firstCondition = firstCondition;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + ":Start");
		lk.lock();
			while(!this.ct.isStarted()){
				try {
					this.normalCondition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			lastCondition.signalAll();
		lk.unlock();
		
		for(int i = 0 , j = 100 ; i < j ; i++){
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}
		
		lk.lock();
			ct.add();
			System.out.println(Thread.currentThread().getName() + "是第"  + ct.getI() + "个完成的");
			lastCondition.signalAll();
		lk.unlock();

	}

}
