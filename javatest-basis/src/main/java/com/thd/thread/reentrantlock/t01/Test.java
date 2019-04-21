package com.thd.thread.reentrantlock.t01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	/**
	 * ReentrantLock的使用
	 * 
	 * ReentrantLock.lock 相当于 synchornized 语句块开始
	 * ReentrantLock.unLock 相当于 synchornized 语句块结束
	 * 
	 * 
	 * 可以使用Condition cdt = lock.newCondition();来创建Condition对象
	 * Condition.await()相当于 Object.wait();
	 * Condition.signal()相当于 Object.notify();
	 * 但是根据Condition对象不同,可以解决Object.notify()方法不能保证肯定唤醒异类的问题
	 * 
	 * 具体例子可以参见 @MessageService
	 * @param args
	 */
	public static void main(String[] args) {
		List<Message> l = new ArrayList<Message>();
		MessageService ms = new MessageService(l);
		
		int producerNum = 2;
		int consumerNum = 2;
		
		List<Thread> threadList = new ArrayList<Thread>();
		for(int i = 0 ; i < producerNum ; i++ ){
			Thread producerThread = new Thread(new ProducerThread(ms),"生产者[" + i + "]");
			producerThread.start();
		}
		
		for(int i = 0 ; i < consumerNum ; i++ ){
			Thread consumerThread = new Thread(new ConsumerThread(ms),"消费者[" + i + "]");
			consumerThread.start();
		}
	
		System.out.println("start -----------");
		
	
		
		
		while(true){
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Iterator<Thread> iter = threadList.iterator();
			while(iter.hasNext()){
				Thread t = iter.next();
				System.out.println(" - " + t.getName() + ":" + t.getState());
			}
		}
		

	}

}
