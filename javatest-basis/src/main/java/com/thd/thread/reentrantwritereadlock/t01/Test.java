package com.thd.thread.reentrantwritereadlock.t01;

public class Test {
	
	public static void testReadLock(){
		MessageService ms = new MessageService();
		Thread t1 = new Thread(new MessageThread(ms,"read"),"readA");
		Thread t2 = new Thread(new MessageThread(ms,"read"),"readB");
		//都是读锁可以并行
		t1.start();
		t2.start();
		/**
readB read begin 
readA read begin 
readA read end 
readB read end 
		 */
	}
	
	public static void testWriteLock(){
		MessageService ms = new MessageService();
		Thread t1 = new Thread(new MessageThread(ms,"write"),"writeA");
		Thread t2 = new Thread(new MessageThread(ms,"write"),"writeB");
		//都是写锁不可以并行
		t1.start();
		t2.start();
		/**
		writeA write begin 
		writeA write end 
		writeB write begin 
		writeB write end 
				 */
	}
	
	public static void testReadWriteLock(){
		MessageService ms = new MessageService();
		Thread t1 = new Thread(new MessageThread(ms,"read"),"readA");
		Thread t2 = new Thread(new MessageThread(ms,"write"),"writeA");
		//读锁和写锁并发,不可并行
		t1.start();
		t2.start();
		/**
readB read begin 
readA read begin 
readA read end 
readB read end 
		 */
	}
	
	public static void main(String[] args) {
		//Test.testReadLock();
		//Test.testWriteLock();
		Test.testReadWriteLock();
		/**
		readA read begin 
		readA read end 
		writeA write begin 
		writeA write end 
				 */
	}

}
