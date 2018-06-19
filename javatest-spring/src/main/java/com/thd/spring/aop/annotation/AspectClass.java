package com.thd.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect 标志是一个切面
//@Component 是自动被初始化(不用在spring配置中配<bean .../>)
@Aspect
@Component
public class AspectClass {
	
	//直接注入符合匹配类型的方法
	@Before("execution (* com.thd.spring.aop.annotation.*.save(..))")
	public void before(JoinPoint jp){
		System.out.println("methodbefore!");
		System.out.println("被代理的对象:" + jp.getThis());
		Object[] objs = jp.getArgs();
		System.out.println("参数：" + objs[0].toString());
	}
	
	//用指定带有@Pointcut标识的方法 注入  指向的是下面的myMethod
	@After("myMethod()")
	public void after(){
		System.out.println("methodafter -- !");
	}
	
	//定义一个叫 myMethod的Pointcut
	@Pointcut("execution (* com.thd.spring.aop.annotation.*.save(..))")
	public void myMethod() {}
	
	
	
}
