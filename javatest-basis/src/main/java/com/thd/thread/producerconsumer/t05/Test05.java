package com.thd.thread.producerconsumer.t05;

import java.util.ArrayList;
import java.util.List;

public class Test05 {

	public static void main(String[] args) {
		String lock = new String("");
		
		P p = new P(lock);
		C c = new C(lock);
		
		ThreadP tp = new ThreadP(p);
		ThreadC tc1 = new ThreadC(c);
		ThreadC tc2 = new ThreadC(c);
		
		tp.setName(" Producer ");
		tc1.setName(" Consumer1 ");
		tc2.setName(" Consumer2 ");
		
		tc1.start();
		tc2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tp.start();

	}
	
	/*
	 * 解决com.thd.thread.producerconsumer.t04例子中 执行wait前判断条件变化的问题
	 * 判断是否需要wait永远要用while！ 防止被notify唤醒后 判断条件已经不是wait前的判断结果(被其他线程把被判断的对象内容改了)
	 */

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
				while(ValueObject.list.size() != 0) {
					lock.wait();
				}
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				ValueObject.list.add(value);
				System.out.println(Thread.currentThread().getName() + " 生产 ValueObject.value = " + value);
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
				System.out.println(Thread.currentThread().getName() + "   消费  " );
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
		p.setValue();
	}
}

class ThreadC extends Thread{
	private C c ;
	public ThreadC(C c) {
		this.c = c;
	}
	
	public void run() {
		c.getValue();
	}
}