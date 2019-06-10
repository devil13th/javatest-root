package com.thd.spring.annotation.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//开启基于AOP注解的模式
@EnableAspectJAutoProxy
@ComponentScan
public class MainConfig {
	
	// 打开一下注释就可以去掉MainConfig的@ComponentScan注释以及MathService和MyAspectJ的@Component注释
	/*//业务逻辑类加入容器中
	@Bean
	public MathService mathService(){
		return new MathService();
	}

	//切面类加入到容器中
	@Bean
	public MyAspectJ myAspectJ(){
		return new MyAspectJ();
	}*/
}
