package com.thd.thread.api.t02sleep.t03;

public class ThreadLockThread implements Runnable {
	private ThreadLock threadLock ;
	private String type;
	public ThreadLockThread(ThreadLock threadLock,String type){
		this.threadLock = threadLock;
		this.type = type;
	}
	@Override
	public void run() {
		if("a".equals(type)){
			threadLock.add();
		}
		
		if("b".equals(type)){
			threadLock.subtract();
		}
	}

}
