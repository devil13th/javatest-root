package com.thd.spring.annotation.beanpostprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * 
 * BeanPostProcessor：在Bean被初始化前后返回一个对象,将该对象注册到IOC容器(可以替换原有对象,例如aop的代理对象替换被代理的对象)
 * 
 * BeanPostProcessor及自定义注释使用例子
 * 将带有自定义注释MyAnnotation的Bean在向SpringIOC容器注册的时候转换为MyAnnotation.transferTo属性的类的实例
 * 
 * BeanPostProcessor的使用例子
 * 
 */
public class MainTest {

	public static void main(String[] args) {
		//用配置类文件构建ApplicationContext,将配置类传入
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		System.out.println("-----------IOC 容器初始化完成------------");
		
		
		System.out.println(" ---------------- IOC中的Ben -------------");
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for(String name : beanNames){
			System.out.println(name);
		}
		
		Animal a = (Animal)applicationContext.getBean("fruit");
		a.animalMethod();
		System.out.println(" ---------------- 关闭容器 -------------");
		//关闭容器调用Bean的销毁方法
		applicationContext.close();
	}

}
