package com.thd.spring.annotation.beanpostprocessor;

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
		
		
		MyAnnotation[] ma = bean.getClass().getAnnotationsByType(MyAnnotation.class);
		if(ma != null && ma.length > 0 ){
			
			for(int i = 0 , j = ma.length ; i < j ; i++){
				
				String classFullNameOfTransfer = ma[i].transferTo();
				Class c;
				try {
					c = Class.forName(classFullNameOfTransfer);
					Object obj = c.newInstance();
					
					System.out.println("########## 这里是BeanPostProcess接口功能的体现");
					System.out.println("########## 利用接口BeanPostProcess 开始对带有MyAnnotation注释的Bean进行转换");
					System.out.println("########## 将Bean[" + bean.getClass().getName() + "]转换为[" + classFullNameOfTransfer + "]" );
					
					
					return obj;
				} catch (Exception e) {
					System.out.println("类型转换错误!");
					return bean;
				}
				
			}
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println( beanName + " postProcessAfterInitialization 方法执行 -> " + bean);
		
		return bean;
	}

}
