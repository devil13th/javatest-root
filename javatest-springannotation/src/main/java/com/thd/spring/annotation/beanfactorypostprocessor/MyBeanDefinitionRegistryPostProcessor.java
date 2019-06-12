package com.thd.spring.annotation.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("------------ MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory start ------------- ");
		String[] names = beanFactory.getBeanDefinitionNames();
		for(String name : names){
			System.out.println(name);
		}
		System.out.println("------------ MyBeanDefinitionRegistryPostProcessor.postProcessBeanFactory end ------------- ");
		
		
	}

	public void postProcessBeanDefinitionRegistry(
			BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("------------ MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry start ------------- ");
		String[] names = registry.getBeanDefinitionNames();
		for(String name : names){
			System.out.println(name);
		}
		
		
		//需要注册的Bean
		BeanDefinition bd = new RootBeanDefinition(Person.class);
		//向ioc容器中注册的bean
		registry.registerBeanDefinition("Person", bd);
		
		System.out.println("使用MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry向容器中注册bean的定义信息");
		System.out.println("------------ MyBeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry end ------------- ");
		
	}


}
