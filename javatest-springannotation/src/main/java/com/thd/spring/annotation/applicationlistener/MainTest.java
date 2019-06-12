package com.thd.spring.annotation.applicationlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		applicationContext.publishEvent(new ApplicationEvent(applicationContext){});
		applicationContext.publishEvent(new MyEvent(applicationContext));
//		for(String name : beanNames){
//			System.out.println(name);
//		}
		applicationContext.close();
		
		/**
		 * 1.创建一个ApplicatoinEvent的子类(创建事件)
		 * 2.将监听器加入容器(@Component注释)
		 * 3.容器中有相关事件发布的时候会调用相应事件的监听
		 * 
		 */
	}

}
