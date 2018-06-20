package com.thd.thread.producerconsumer.t02;

import java.util.ArrayList;
import java.util.List;

public class Test02 {

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
		 * 假死 . 所有的线程都wait住了
		 * 
		 * 
		 * 消费者2执行  value=""   wait  p1|p2|c1|c2  =>  就绪|就绪|等待|等待
		 * 消费者1执行  value=""   wait  p1|p2|c1|c2  => 就绪|就绪|等待|等待
		 * 生产者1执行  value=""  唤醒消费者2 循环下一次   wait  p1|p2|c1|c2  => 等待|就绪|等待|就绪
		 * 生产者2执行  value="x"  wait  p1|p2|c1|c2  => 等待|等待|等待|就绪
		 * 消费者2执行  value="x" 唤醒消费者1 循环下一次   wait p1|p2|c1|c2  => 等待|等待|就绪|等待
		 * 消费者1执行  value=""   wait  p1|p2|c1|c2  => 等待|等待|等待|等待 => 假死
		 * 
		 * 
		 * 生产者1执行  set value="xxx"   后进入下次循环后  wait               p1|p2|c1|c2  =>    等待|就绪|就绪|就绪
		 * 生产者2执行  因为value有值                      wait              p1|p2|c1|c2  =>    等待|等待|就绪|就绪
		 * 消费者1执行  set value=""      唤醒生产者1 进入下次循环后    wait    p1|p2|c1|c2  =>    就绪|等待|等待|就绪
		 * 生产者1执行  set value="xxx"   唤醒生产者2后进入下一循环  wait       p1|p2|c1|c2  =>    等待|就绪|等待|就绪
		 * 生产者2执行  因为value有值                      wait              p1|p2|c1|c2  =>    等待|等待|等待|就绪
		 * 消费者2执行  set Value=""     唤醒消费者1 进入下次循环后 wait        p1|p2|c1|c2  =>    等待|等待|等待|就绪
		 * 消费者1执行  因为value没有值                    wait               p1|p2|c1|c2  =>    等待|等待|等待|等待
		 * 
		 * 
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
				while(ValueObject.value.equals("")) {
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