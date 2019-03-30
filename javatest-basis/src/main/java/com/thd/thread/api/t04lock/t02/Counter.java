package com.thd.thread.api.t04lock.t02;


public class Counter {
	//线程结束关闭控制  关闭:false  运行:true
	public static boolean control = true;
	public static Integer a = 0;
	//同步方法 - 实质上锁的是this对象
	synchronized public static void add(){
		while(control){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a++;
			System.out.println("add" + a);
		}
	}
	
	//锁的是this对象   可以将synchronized(this)改为synchronized(lock)后再查看执行结果
	public void substract(){
		//synchronized(lock){
		synchronized(Counter.class){
			while(control){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				a--;
				System.out.println("substract" + a);
			}
		}
	}
	
	public static void exit(){
		control = false;
	}
	
}
