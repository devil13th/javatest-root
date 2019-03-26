package com.thd.thread.api.t06interrupt;

public class Test06b {

	public static void main(String[] args) throws InterruptedException {
		//将当前线程标记中断状态
		Thread.currentThread().interrupt();
		
		
		
		//Thread.interrupt() 判断当前线程状态是否是中断状态,并清除该状态  -- true
		System.out.println("1.是否停止？"  + Thread.interrupted()); 
		//因上一行代码清除了中断状态 所以打印false
		System.out.println("2.是否停止？"  + Thread.interrupted()); 
		System.out.println("2.是否停止？"  + Thread.interrupted()); 
		System.out.println("2.是否停止？"  + Thread.interrupted()); 
		System.out.println("2.是否停止？"  + Thread.interrupted()); 
		
		System.out.println("--------------");
		
		//将当前线程标记中断状态
		Thread.currentThread().interrupt();
		//Thread.interrupt() 判断当前线程状态是否是中断状态,并清除该状态  -- true
		System.out.println("3.是否停止？"  + Thread.interrupted()); 
		//因上一行代码清除了中断状态 所以打印false
		System.out.println("4.是否停止？"  + Thread.interrupted()); 
		System.out.println("4.是否停止？"  + Thread.interrupted()); 
		System.out.println("4.是否停止？"  + Thread.interrupted()); 
		System.out.println("4.是否停止？"  + Thread.interrupted()); 
				
				
	}

}
