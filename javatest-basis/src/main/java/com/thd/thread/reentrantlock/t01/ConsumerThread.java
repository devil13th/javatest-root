package com.thd.thread.reentrantlock.t01;

public class ConsumerThread implements Runnable {
	
	private MessageService consumer;
	
	public ConsumerThread(MessageService consumer){
		this.consumer = consumer;
	}
	@Override
	public void run() {
		while(true){
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			Message ms = this.consumer.consumerMessage();
		}
		
	}

}
