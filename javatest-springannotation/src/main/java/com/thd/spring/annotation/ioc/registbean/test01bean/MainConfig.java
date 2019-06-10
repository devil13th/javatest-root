package com.thd.spring.annotation.ioc.registbean.test01bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Configuration 告诉spring这是一个配置类相当于传统xml配置文件
@Configuration

//@ComponentScan 告诉spring扫描哪些包
//将这些包中带有@Component,@Controller,@Service,@Repository的类注册到IOC容器中
@ComponentScan(basePackages="com.thd.spring.annotation.ioc.registbean")

@Import({Fruit.class})
public class MainConfig {
	
	//@Bean 给容器中注册一个bean,bean的id是方法名,实例对象是该方法的返回值
	//如果要改名字则需要设置name属性
	@Bean(name="personBean")
	public Person person(){
		return new Person("devil13th",15);
	}
	
	//如果@Bean返回的bean是FactoryBean接口的实现类,则向IOC注入的是该实现类实现方法返回的bean
	@Bean
	public MyFactoryBean myFactoryBean(){
		return new MyFactoryBean();
	}
	
	
}
