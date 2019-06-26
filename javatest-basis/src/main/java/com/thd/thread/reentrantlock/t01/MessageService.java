package com.thd.thread.reentrantlock.t01;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MessageService {
	volatile public List<Message> queue;
	//锁
	private ReentrantLock lock = new ReentrantLock();
	
	//下面创建的两个Condition 分别代表生产者类型 和 消费者类型,当使用 Condition对象的await()方法的时候是对Condition对象进行获取锁,以便调用signal的时候可以有针对性的唤醒异类
	//用于控制生产者
	private Condition producerCondition = lock.newCondition();
	//用于控制消费者
	private Condition consumerCondition = lock.newCondition();
	
	
	public MessageService(List<Message> queue){
		this.queue = queue;
	}
	
	//消费者 消费消息
	public Message consumerMessage(){
		
		Message ms = null;
		//相当于 synchronized(Object) 语句块开始
		lock.lock();
		while(queue.size() <= 0){
			System.out.println("                                                                " + Thread.currentThread().getName() + " Waiting " );
			try {
				//相当于 Object.wait();
				consumerCondition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//System.out.println(Thread.currentThread().getName() + "---------------------");
		ms = queue.remove(queue.size()-1);
		if(queue.size() == 2){
			//相当于Object.notify
			producerCondition.signal();
		}
		//System.out.println(Thread.currentThread().getName() + " - " + ms);
		System.out.println("                                                                " + Thread.currentThread().getName() + " Running - " + ms);
		//System.out.println(Thread.currentThread().getName() + "---------------------");
		
		//相当于synchronized 语句块结束
		lock.unlock();
		
		return ms;
	}
	
	public Message createMessage(String name){
		
		Message ms = null;
		//相当于 synchronized(Object) 语句块开始
		lock.lock();
		while(queue.size() > 15){
			System.out.println(Thread.currentThread().getName() + " Waiting " );
			try {
				producerCondition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//System.out.println(Thread.currentThread().getName() + "+++++++++++++++++");
		ms = new Message("[" + queue.size() + "]");
		System.out.println(Thread.currentThread().getName() + " Running + " + ms);
		queue.add(ms);
//			System.out.println(Thread.currentThread().getName() + " + " + ms);
		if(queue.size() == 15){
			//相当于Object.notify
			consumerCondition.signal();
		}
		//System.out.println(Thread.currentThread().getName() + "+++++++++++++++++");
		//相当于synchronized 语句块结束
		lock.unlock();
		return ms;
	}
}
