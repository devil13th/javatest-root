package com.thd.spring.annotation.ioc.registbean.test01bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.thd.spring.annotation.ioc.registbean.other.OtherPackageBean;

public class MainTest {

	public static void main(String[] args) {
		//用配置类文件构建ApplicationContext,将配置类传入
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
		System.out.println("-----------IOC 容器初始化完成------------");
		
		//通过在配置类中的@Bean注入某个bean
		Person p = applicationContext.getBean(Person.class);
		System.out.println(p.getName());
		
		Person p1 = (Person)applicationContext.getBean("personBean");
		System.out.println(p1.getName());
		
		
		//通过在类上加入@Component注释导入 (指定包扫描,在主配置类上加入@ComponentScan)
		System.out.println("@Component 注入");
		OtherPackageBean op = (OtherPackageBean)applicationContext.getBean("otherPackageBean");
		System.out.println(op.getName());
		
		//通过在Class上加@Component导入 
		System.out.println("@Component 注入");
		Animal animal1 = (Animal)applicationContext.getBean("AnimalBean");
		System.out.println(animal1.getName());
		Animal animal2 = (Animal)applicationContext.getBean("AnimalBean");
		System.out.println(animal2.getName());
		
		//通过在配置类中加入@Import导入的类

		System.out.println("@Import 注入");
		Fruit fruit = (Fruit)applicationContext.getBean("com.thd.spring.annotation.ioc.registbean.test01bean.Fruit");
		System.out.println(fruit.getName());
		
		//通过@Bean导入,但是@Bean返回的是BeanFactory的实现类
		System.out.println("FactoryBean 注入");
		ByFactoryBean bfb = (ByFactoryBean)applicationContext.getBean("myFactoryBean");
		System.out.println(bfb.getName());
		
		System.out.println(" ---------------- IOC中的Ben -------------");
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for(String name : beanNames){
			System.out.println(name);
		}
	}

}
