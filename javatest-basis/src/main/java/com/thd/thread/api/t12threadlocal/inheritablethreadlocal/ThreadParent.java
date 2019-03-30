package com.thd.thread.api.t12threadlocal.inheritablethreadlocal;

public class ThreadParent implements Runnable{
	
	public void run(){
		//父线程对ThreadVar.itl赋值
		ThreadVar.itl.set("我是父线程" + Thread.currentThread().getName() + "设置的ThreadLocal" );
		System.out.println(Thread.currentThread().getName() + ":" +ThreadVar.itl.get());
		
		//创建并启动子线程
		Thread t = new Thread(new ThreadChild());
		t.setName("Child Thread");
		t.start();
	}
}
