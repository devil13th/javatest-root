package com.thd.spring.annotation.ioc.configuration.imports.importbeandefinitionregistrar;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	public void registerBeanDefinitions(
			AnnotationMetadata importingClassMetadata,
			BeanDefinitionRegistry registry) {
		//如果注册了名为peronsBean的bean(去掉在MainConfig中将personBean的注释)
		boolean condition = registry.containsBeanDefinition("personBean");
		
		if(condition){
			//需要注册的Bean
			BeanDefinition bd = new RootBeanDefinition(Animal.class);
			//向ioc容器中注册的bean
			registry.registerBeanDefinition("MyAnimal", bd);
		}
		
		BeanDefinition bd2 = new RootBeanDefinition(Fruit.class);
		registry.registerBeanDefinition("MyFruit", bd2);
	}

	

}
