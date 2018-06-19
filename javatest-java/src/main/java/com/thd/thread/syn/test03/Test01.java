package com.thd.thread.syn.test03;

public class Test01 implements Runnable{
	Timer tim=new Timer();
	public static void main(String[] args){
		
		Test01 t = new Test01();
		
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		
		t1.setName("t1");
		t2.setName("t2");
		
		t1.start();
		t2.start();
		
	}
	
	public void run(){
		tim.add(Thread.currentThread().getName());
	}
}


class Timer{
	public static int num=0;
	public void add(String name){
		synchronized(this){
		num++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + ":第" + num + "个线程");
		}
	}
}