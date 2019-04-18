package com.thd.thread.producerconsumer.fakedead;

import java.util.List;

public class MessageProducer {
	volatile public List<Message> queue;
	
	public MessageProducer(List<Message> queue){
		this.queue = queue;
	}
	
	public Message createMessage(String name){
		
		Message ms = null;
		synchronized(queue){
			while(queue.size() > 15){
				System.out.println(Thread.currentThread().getName() + " Waiting " );
				try {
					queue.wait();
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
				queue.notify();
			}
			//System.out.println(Thread.currentThread().getName() + "+++++++++++++++++");
		}
		return ms;
	}
}
