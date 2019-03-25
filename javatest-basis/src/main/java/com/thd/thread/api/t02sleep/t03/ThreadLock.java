package com.thd.thread.api.t02sleep.t03;

import java.util.ArrayList;
import java.util.List;

public class ThreadLock {
	
	private Integer l = 0;
	public ThreadLock(Integer l){
		this.l = l;
	}
	
	public synchronized void add (){
		System.out.println("add");
		for(int i = 0 , j = 10 ; i < j ; i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			l++;
			System.out.println(Thread.currentThread().getName() + " add " + i);
				
		}
		
	}
	/**
	 * 所谓的同步方法其实锁的是this对象
	 */
	public  void subtract (){
		synchronized(this){
			System.out.println("subtract");
			for(int i = 0 , j = 10 ; i < j ; i++){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				l--;
				System.out.println(Thread.currentThread().getName() + " subtract " + i);
					
			}
		}
	}
}
