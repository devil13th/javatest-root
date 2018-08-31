package com.thd.thread.api.t06interrupt;

public class Test06b {

	public static void main(String[] args) throws InterruptedException {
		//设置当前线程状态为停止
		Thread.currentThread().interrupt();
		
		//Thread.interrupt() 判断当前线程状态是否是停止状态,并清除该状态  -- true
		System.out.println("1.是否停止？"  + Thread.interrupted()); 
		//因上一行代码清除了停止状态 所以打印false
		System.out.println("2.是否停止？"  + Thread.interrupted()); 
	}

}
