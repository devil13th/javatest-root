package com.thd.thread.reentrantlock.t01;

public class Message {
	private String messageName;

	public String getMessageName() {
		return messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}

	public Message(String messageName) {
		super();
		this.messageName = messageName;
	}
	public String toString(){
		return this.messageName;
	}
}
