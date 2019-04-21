package com.thd.thread.reentrantwritereadlock.t01;

public class MessageThread implements Runnable{
	private MessageService messageService;
	private String type;
	
	public MessageThread(MessageService messageService,String type){
		this.messageService = messageService;
		this.type = type;
	}
	
	public void run(){
		if(type.equals("read")){
			this.messageService.read();
		}else{
			this.messageService.write();
		}
	}
	
}
