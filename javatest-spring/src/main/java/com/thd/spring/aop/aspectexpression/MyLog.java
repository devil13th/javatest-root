package com.thd.spring.aop.aspectexpression;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public interface  MyLog {
	//方法之前执行
	public void beforeMethod(JoinPoint jp);
	//方法之后执行
	public void afterMethod(JoinPoint jp);
	//方法前后环绕
	public Object aroundMethod(ProceedingJoinPoint  pjp);
	//抛出异常后执行
	public void throwsMethod(JoinPoint pj,Exception e);
}
