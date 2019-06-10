package com.thd.spring.annotation.ioc.lifecycle.test05postprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/*
 * 创建一个类
 * 实现BeanPostProcessor接口的postProcessBeforeInitialization和postProcessAfterInitialization方法
 * 在每个bean初始化前和初始化后执行
*/
@Component
public class MyPostProcess implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println( beanName + " postProcessBeforeInitialization 方法执行 -> " + bean);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println( beanName + " postProcessAfterInitialization 方法执行 -> " + bean);
		
		return bean;
	}

}
