package com.thd.spring.annotation.ioc.configuration.imports.importbeandefinitionregistrar;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration

//使用@Import导入具体的类,该类实现了ImportSelector接口,定义了需要导入的类名数组
@Import({MyImportBeanDefinitionRegistrar.class})
public class MainConfig {
	/*
	//@Bean 给容器中注册一个bean,bean的id是方法名,实例对象是该方法的返回值
	//如果要改名字则需要设置name属性
	@Bean(name="personBean")
	public Person person(){
		return new Person("devil13th",15);
	}*/
}
