package com.thd.spring.annotation.ioc.lifecycle.test07beanfactorypostprocess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;
@Component
public class MyBeanFactoryPostProcess implements BeanFactoryPostProcessor {

	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] names =  beanFactory.getBeanDefinitionNames();
		System.out.println(" ------------  beanfactory post process ---------  ");
		for(String name : names){
			System.out.println(name);
		}
	}

}
