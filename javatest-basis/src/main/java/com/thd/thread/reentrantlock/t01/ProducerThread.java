package com.thd.thread.reentrantlock.t01;

public class ProducerThread implements Runnable {
	
	private MessageService producer;
	
	public ProducerThread(MessageService producer){
		this.producer = producer;
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
			Message ms = this.producer.createMessage(String.valueOf(System.currentTimeMillis()));
			
		}
		
	}

}
