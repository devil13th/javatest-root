package com.thd.spring.annotation.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * 通过实现InitializingBean接口实现Bean初始化方法
 * 通过实现DisposableBean接口实现Bean的销毁方法
 */
public class MainTest {

	public static void main(String[] args) {
		//用配置类文件构建ApplicationContext,将配置类传入
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		System.out.println("-----------IOC 容器初始化完成------------");
		
		
		//使用懒加载方式,需要打开Animal中的@Lazy
		Animal animal = (Animal)applicationContext.getBean("animal");

		System.out.println(" ----------  获取applicationContext");
		System.out.println(animal.getApplicationContext());
		System.out.println(" ----------  获取environment");
		System.out.println(animal.getEnvironment());
		System.out.println(" ----------  获取properties文件name属性");
		System.out.println(animal.getEnvironment().getProperty("name"));
		System.out.println(" ----------  获取beanFactory");
		System.out.println(animal.getBeanFactory());
		
//		System.out.println(" ---------------- IOC中的Ben -------------");
//		String[] beanNames = applicationContext.getBeanDefinitionNames();
//		for(String name : beanNames){
//			System.out.println(name);
//		}
		System.out.println(" ---------------- 关闭容器 -------------");
		//关闭容器调用Bean的销毁方法
		applicationContext.close();
	}

}
