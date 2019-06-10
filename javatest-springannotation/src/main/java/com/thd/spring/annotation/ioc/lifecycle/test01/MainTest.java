package com.thd.spring.annotation.ioc.lifecycle.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.thd.spring.annotation.ioc.registbean.other.OtherPackageBean;
/**
 * 通过@Bean(initMethod="init",destroyMethod="destory") 指定Bean创建的初始化方法和销毁方法
 */
public class MainTest {

	public static void main(String[] args) {
		//用配置类文件构建ApplicationContext,将配置类传入
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		System.out.println("-----------IOC 容器初始化完成------------");
		//使用懒加载方式,需要打开MainConfig中animal方法中的@Lazy
		//Animal animal = (Animal)applicationContext.getBean("animal");
		
		System.out.println(" ---------------- IOC中的Ben -------------");
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for(String name : beanNames){
			System.out.println(name);
		}
		System.out.println(" ---------------- 关闭容器 -------------");
		//关闭容器调用Bean的销毁方法
		applicationContext.close();
	}

}
