package com.thd.thread.producerconsumer.t01;

public class Test01 {

	public static void main(String[] args) {
		String lock = new String("");
		
		P p = new P(lock);
		C c = new C(lock);
		
		ThreadP tp = new ThreadP(p);
		ThreadC tc = new ThreadC(c);
		
		tp.setName(" Producer ");
		tc.setName(" Consumer ");
		
		tc.start();
		tp.start();

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
				if(!ValueObject.value.equals("")) {
					lock.wait();
				}
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				ValueObject.value = value;
				System.out.println(Thread.currentThread().getName() + " set() ValueObject.value = " + value);
				lock.notify();
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
				if(ValueObject.value.equals("")) {
					lock.wait();
				}
				String value = ValueObject.value;
				System.out.println(Thread.currentThread().getName() + "   get() ValueObject.value = " + value);
				ValueObject.value = "";
				lock.notify();
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