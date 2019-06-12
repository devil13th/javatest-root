package com.thd.spring.annotation.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("------------ MyBeanFactoryPostProcessor ------------- ");
		String[] names = beanFactory.getBeanDefinitionNames();
		for(String name : names){
			System.out.println(name);
		}

	}

}
