package com.thd.thread.reentrantwritereadlock.t01;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MessageService {
	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public MessageService(){
		
	}
	
	public void read(){
		lock.readLock().lock();
		System.out.println(Thread.currentThread().getName() + " read begin ");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " read end ");
		lock.readLock().unlock();
	}
	
	public void write(){
		lock.writeLock().lock();
		System.out.println(Thread.currentThread().getName() + " write begin ");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " write end ");
		lock.writeLock().unlock();
	}
	
	
}
