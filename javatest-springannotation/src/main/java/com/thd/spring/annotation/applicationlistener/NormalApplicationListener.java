package com.thd.spring.annotation.applicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
// ApplicationEvent 是需要监听的事件的类型
public class NormalApplicationListener implements ApplicationListener<ApplicationEvent> {
	
	/**
	 * 当容器中发布了此事件后触发该方法
	 */
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		System.out.println("触发的事件:" + event);
	} 

}
