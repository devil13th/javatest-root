package com.thd.thread.producerconsumer.t03;

import java.util.ArrayList;
import java.util.List;

public class Test03 {

	public static void main(String[] args) {
		String lock = new String("");
		
		P p = new P(lock);
		C c = new C(lock);
		
		List<Thread> l = new ArrayList<Thread>();
		
		for(int i = 0 ; i < 2 ; i++) {
			ThreadP tp_p = new ThreadP(p);
			ThreadC tc_c = new ThreadC(c);
			
			tp_p.setName(" Producer_" + i);
			tc_c.setName(" Consumer_" + i);
			
			tc_c.start();
			tp_p.start();
			
			l.add(tp_p);
			l.add(tc_c);
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int i = 0 , j = l.size() ; i < j ; i++ ) {
			System.out.println(l.get(i).getName() + " " + l.get(i).getState());
		}
		
		
		/*
		 * 避免生产者消费者假死情况(所有的线程都wait住了)
		 * 解决办法：使用notifyAll
		 */

	}

}

class ValueObject{
	public static String value = "";
}

//生产者
class P {
	private String lock;
	public P(String lock) {
		this.lock = lock;
	}
	
	public void setValue() {
		try {
			synchronized(lock){
				while(!ValueObject.value.equals("")) {
					lock.wait();
				}
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				ValueObject.value = value;
				System.out.println(Thread.currentThread().getName() + " set() ValueObject.value = " + value);
				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

//消费者
class C {
	private String lock;
	public C(String lock) {
		this.lock = lock;
	}
	
	public void getValue() {
		System.out.println("-----=-------");
		try {
			synchronized(lock){
				while(ValueObject.value.equals("")) {
					lock.wait();
				}
				String value = ValueObject.value;
				System.out.println(Thread.currentThread().getName() + "   get() ValueObject.value = " + value);
				ValueObject.value = "";
				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		
		}
	}
	
}

class ThreadP extends Thread{
	private P p ;
	public ThreadP(P p) {
		this.p = p;
	}
	
	public void run() {
		while(true) {
			p.setValue();
		}
	}
}

class ThreadC extends Thread{
	private C c ;
	public ThreadC(C c) {
		this.c = c;
	}
	
	public void run() {
		while(true) {
			c.getValue();
		}
	}
}