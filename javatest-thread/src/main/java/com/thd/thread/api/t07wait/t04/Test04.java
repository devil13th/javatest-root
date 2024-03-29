package com.thd.thread.api.t07wait.t04;

import java.util.ArrayList;
import java.util.List;
public class Test04{
	public static void main(String[] args) throws Exception {
		String lock = new String("");
		Add add = new Add(lock);
		Subtract subtract = new Subtract(lock);
		ThreadSubtract subtractThread1 = new ThreadSubtract(subtract);
		ThreadSubtract subtractThread2 = new ThreadSubtract(subtract);
		subtractThread1.setName(" subtractThread1 ");
		subtractThread2.setName(" subtractThread2 ");
		subtractThread1.start();
		subtractThread2.start();
		
		Thread.sleep(1000);
		
		ThreadAdd addThread = new ThreadAdd(add);
		addThread.setName(" addThread ");
		addThread.start();
		/*
		 * 触发wait()的条件发生了变化，执行结果如下
wait begin ThreadName= subtractThread1 
wait begin ThreadName= subtractThread2 
wait end ThreadName= subtractThread1 
list size = 0
wait end ThreadName= subtractThread2 
Exception in thread " subtractThread2 " java.lang.IndexOutOfBoundsException: Index 0 out-of-bounds for length 0
	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
	at java.base/java.util.Objects.checkIndex(Objects.java:372)
	at java.base/java.util.ArrayList.remove(ArrayList.java:517)
	at com.thd.thread.api.t07wait.t04.Subtract.subtract(Test04.java:55)
	at com.thd.thread.api.t07wait.t04.ThreadSubtract.run(Test04.java:84)

		 */
		
	}
}
class ValueObject{
	public static List list = new ArrayList();
}

class Add {
	private String lock;
	public Add(String lock) {
		this.lock = lock;
	}
	public void add() {
		synchronized(lock) {
			ValueObject.list.add("String");
			lock.notifyAll();
		}
	}
}

class Subtract{
	private String lock;
	public Subtract (String lock) {
		this.lock = lock;
	}
	public void subtract() {
		//System.out.println(Thread.currentThread().getName()+ " begin subtract ...");
		try {
			synchronized(lock) {
				if(ValueObject.list.size() == 0) {
					System.out.println("wait begin ThreadName=" + Thread.currentThread().getName());
					Thread.sleep(200);
					lock.wait();
					System.out.println("wait end ThreadName=" + Thread.currentThread().getName());
				}
				ValueObject.list.remove(0);
				System.out.println("list size = " + ValueObject.list.size());
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ThreadAdd extends Thread{
	private Add p ;
	public ThreadAdd(Add p ) {
		super();
		this.p = p;
	}
	
	public void run() {
		p.add();
	}
}

class ThreadSubtract extends Thread{
	private Subtract p ;
	public ThreadSubtract(Subtract p ) {
		super();
		this.p = p;
	}
	
	public void run() {
		p.subtract();
	}
}
