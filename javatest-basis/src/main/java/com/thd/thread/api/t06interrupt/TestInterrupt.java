package com.thd.thread.api.t06interrupt;


public class TestInterrupt{
	
	public static void main(String[] args){
		testBasicInterrupt();
		//testSleepThenInterrupt();
		//testInterruptedBasic();
		//testIsInterrupted();
	}
	
	/**
	 * thread.interrupt()基本使用方法
	 * 该方法将线程实例标记中断状态(仅仅做标记,不做其他操作,不会停止线程执行)
	 */
	public static void testBasicInterrupt() {
		Thread t = new Thread(new Web1230606(),"张三");
		t.start();
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//interrupt()并不能中断线程，而是做了一个暂停标记 执行interrupt后t进程仍然在输出
		t.interrupt();
		//可以通过thread.isInterrupt()方法判断进程是否已打上中断标记
		System.out.println(t.isInterrupted() + "------------");
		
		/*输出结果
[...]
当前线程(张三)是否已被中断:false
张三抢到第[272]张票
当前线程(张三)是否已被中断:false
张三抢到第[271]张票
当前线程(张三)是否已被中断:true
张三抢到第[270]张票
当前线程(张三)是否已被中断:true
[...]
张三抢到第[263]张票
当前线程(张三)是否已被中断:true
张三抢到第[262]张票
当前线程(张三)是否已被中断:true
张三抢到第[261]张票
true------------
当前线程(张三)是否已被中断:true
张三抢到第[260]张票
当前线程(张三)是否已被中断:true
张三抢到第[259]张票
当前线程(张三)是否已被中断:true
[...]
true------------
当前线程(张三)是否已被中断:true
张三抢到第[260]张票
当前线程(张三)是否已被中断:true
张三抢到第[259]张票
当前线程(张三)是否已被中断:true
[...]
		 
		 */
		
	}
	
	
	/**
	 * thread.interrupt()
	 * 如果该方法调用时,线程实例正在sleep则抛出异常并清空中断标记
	 * 如果调用该方法后线程调用Thread.sleep()方法则也会抛出异常并清空中断标记
	 * 
	 */
	public static void testSleepThenInterrupt() {
		Thread t = new Thread(new Web1230606a(),"张三");
		t.start();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//interrupt()并不能中断线程
		//而是做了一个暂停标记 执行interrupt后t进程仍然在输出
		//如果该线程正在sleep则抛出异常并清除该线程的中断标记
		//如果标记为中断的线程进入sleep也会抛出异常并清除该线程的中断标记
		t.interrupt();
		//可以通过thread.isInterrupt()方法判断进程是否已打上中断标记
		System.out.println(t.isInterrupted() + "------------");
		
		
	}
	
	/**
	 * Thread.interrupt()
	 * 该方法返回"当前"正在运行的进行是否被标记为中断(是否被调用过interrupt())并且清除中断标记
	 * 
	 * 
	 */
	public static void testInterruptedBasic(){
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
	
	/**
	 * thread.isInterrupted()
	 * 该方法判断调用isInterrupted()的线程实例是否被标记为中断状态
	 * 区别Thread.interrupted()方法,thread.isInterrupted()方法不会清除线程的中断状态
	 */
	public static void testIsInterrupted(){
		//设置当前线程状态为停止
		Thread.currentThread().interrupt();
		//Thread.currentThread().interrupted() 判断当前线程状态是否是停止状态,不会清除该状态  -- true
		System.out.println("1.是否停止？"  + Thread.currentThread().isInterrupted()); 
		//因上一行代码不会清除了停止状态 所以打印true
		System.out.println("2.是否停止？"  + Thread.currentThread().isInterrupted()); 
	}
	
}
