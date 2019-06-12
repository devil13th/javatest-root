package com.thd.spring.annotation.applicationlistener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
// ApplicationEvent 是需要监听的事件的类型
public class MyApplicationListener implements ApplicationListener<MyEvent> {
	
	/**
	 * 当容器中发布了此事件后触发该方法
	 */
	public void onApplicationEvent(MyEvent event) {
		System.out.println("自定义触发的事件 start============:" + event);
		ApplicationContext applicationContext = (ApplicationContext)event.getSource();
		
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for(String name : beanNames){
			System.out.println(name);
		}
		System.out.println("自定义触发的事件 finish============:" + event);
	} 

}
