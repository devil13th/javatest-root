package com.thd.thread.producerconsumer.t04;

import java.util.ArrayList;
import java.util.List;

public class Test04 {

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
	 * 运行结果
	 * 
----- ==  Consumer1  开始消费 == -------
----- ==  Consumer2  开始消费 == -------
 Producer  生产 ValueObject.value = 1525138798383_175473137119409
 Consumer1    消费  
Exception in thread " Consumer2 " java.lang.IndexOutOfBoundsException: Index 0 out-of-bounds for length 0
	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
	at java.base/java.util.Objects.checkIndex(Objects.java:372)
	at java.base/java.util.ArrayList.remove(ArrayList.java:517)
	at com.thd.thread.producerconsumer.t04.C.getValue(Test04.java:79)
	at com.thd.thread.producerconsumer.t04.ThreadC.run(Test04.java:109)
     *
     * 出问题是因为两个消费者在ValueObject.list.size() == 0的时候都wait了,
     * 生产者生产后ValueObject.list中有一个元素后notifyAll唤醒了两个处在if判断体内部的两个消费者线程
     * 第一个消费者开始消费后将ValueObject.list中的第0个元素移除
     * 第二个消费者开始消费，因为wait的时候已经在判断体内，所以继续执行不再验证ValueObject.list.size > 0, 
     * 继续移除ValueObject.list中的第0个元素（此时ValueObject.list中已为空的）,所以抛出异常
     * 
     * 解决办法：
     * 消费者被notify或notifyAll唤醒的时候只要再次检查是否满足ValueObject.list.size > 0即可
     * 所以把if替换成while即可。
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
				if(ValueObject.list.size() != 0) {
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
				if(ValueObject.list.size() == 0 ) {
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