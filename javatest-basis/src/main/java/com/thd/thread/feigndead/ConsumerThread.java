package com.thd.thread.feigndead;

public class ConsumerThread implements Runnable {
	
	private MessageConsumer consumer;
	
	public ConsumerThread(MessageConsumer consumer){
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
