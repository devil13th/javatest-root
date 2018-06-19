package com.thd.thread.producerconsumer.t06;

import java.util.ArrayList;
import java.util.List;

public class Test06 {

	public static void main(String[] args) {
		String lock = new String("");
		
		P p = new P(lock);
		C c = new C(lock);
		
		for(int i = 0 , j = 5 ; i < j ; i++) {
			ThreadP tp = new ThreadP(p);
			ThreadC tc = new ThreadC(c);
			
			tp.setName( "生产者_" + i);
			tc.setName( "消费者_" + i);
			
			tp.start();
			tc.start();
		}
		
		
	}
	
	

}

class ValueObject{
	public static List list = new ArrayList();
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
				while(ValueObject.list.size() > 4 ) {
					lock.wait();
				}
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				ValueObject.list.add(value);
				System.out.println(Thread.currentThread().getName() + " [" + ValueObject.list.size() + "] 生产 ValueObject.value = " + value);
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
		System.out.println("----- == " + Thread.currentThread().getName() + " 开始消费 == -------");
		try {
			synchronized(lock){
				while(ValueObject.list.size() == 0 ) {
					lock.wait();
				}
				ValueObject.list.remove(0);
				System.out.println(Thread.currentThread().getName() + " [" + ValueObject.list.size() + "]   消费  " );
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
		int ct = 11115;
		int i = 0;
		while(i < ct) {
			p.setValue();
			i++;
		}
	}
}

class ThreadC extends Thread{
	private C c ;
	public ThreadC(C c) {
		this.c = c;
	}
	
	public void run() {
		int ct = 11115;
		int i = 0;
		while(i < ct) {
			c.getValue();
			i++;
		}
	}
}