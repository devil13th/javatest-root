package com.thd.spring.annotation.applicationlistener;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
	
	
	public MyEvent(Object source){
		super(source);
	}
	
	@Override
	public Object getSource() {
		return super.getSource();
	}

	@Override
	public String toString() {
		return "This Is My Event";
	}

}
