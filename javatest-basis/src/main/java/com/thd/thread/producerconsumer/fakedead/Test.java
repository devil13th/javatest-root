package com.thd.thread.producerconsumer.fakedead;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
	/**
	 * 假死的例子
	 * 因为使用的是notify()而不是notifyAll(),造成唤醒的线程是同类线程(消费者唤醒消费者或生产者唤醒生产者)
	 * @param args
	 */
	public static void main(String[] args) {
		List<Message> l = new ArrayList<Message>();
		MessageProducer mp = new MessageProducer(l);
		MessageConsumer mc = new MessageConsumer(l);
		
		int producerNum = 2;
		int consumerNum = 2;
		
		List<Thread> threadList = new ArrayList<Thread>();
		for(int i = 0 ; i < producerNum ; i++ ){
			Thread producerThread = new Thread(new ProducerThread(mp),"生产者[" + i + "]");
			producerThread.start();
		}
		
		for(int i = 0 ; i < consumerNum ; i++ ){
			Thread consumerThread = new Thread(new ConsumerThread(mc),"消费者[" + i + "]");
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
