package com.thd.thread.api.t12threadlocal.inheritablethreadlocal;

public class ThreadChild implements Runnable{
	
	public void run(){
		//子线程中直接调用ThreadVar.itl.get()方法可以直接获取父线程中设置的值
		System.out.println(Thread.currentThread().getName() + ":" + ThreadVar.itl.get());
	}
}
