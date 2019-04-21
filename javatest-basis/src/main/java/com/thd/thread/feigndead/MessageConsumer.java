package com.thd.thread.feigndead;

import java.util.List;

public class MessageConsumer {
	volatile public List<Message> queue;
	
	public MessageConsumer(List<Message> queue){
		this.queue = queue;
	}
	
	public Message consumerMessage(){
		
		Message ms = null;
		synchronized(queue){
			
			while(queue.size() <= 0){
				System.out.println("                                                                " + Thread.currentThread().getName() + " Waiting " );
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//System.out.println(Thread.currentThread().getName() + "---------------------");
			ms = queue.remove(queue.size()-1);
			if(queue.size() == 2){
				queue.notify();
			}
			//System.out.println(Thread.currentThread().getName() + " - " + ms);
			System.out.println("                                                                " + Thread.currentThread().getName() + " Running - " + ms);
			//System.out.println(Thread.currentThread().getName() + "---------------------");
		}
		
		return ms;
	}
}
