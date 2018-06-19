package com.thd.spring.aop.configuration.example02;

import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyLogImpl implements MyLog{
	private Logger log = Logger.getLogger("C1");
	public void beforeMethod(JoinPoint jp){
		System.out.println("===========================[[[before]]]:" + jp.getSignature());
	}
	public void afterMethod(JoinPoint jp){
		System.out.println("===========================[[[after]]]:" + jp.getSignature());
	}
	public Object aroundMethod(ProceedingJoinPoint  pjp) {
		System.out.println("===========================[[[around]]]:" + pjp.getSignature());
		try {
			Long beginTime = System.currentTimeMillis();
			Object obj = pjp.proceed();
			Long endTime = System.currentTimeMillis();
			System.out.println("===========================[[[around]]] " + pjp.getSignature()+ " 执行时间:" + (endTime-beginTime));
			return obj;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	public void throwsMethod(JoinPoint jp,Exception ex){
		System.out.println("===========================[[[throws]]]:" + jp.getSignature());
		System.out.println("===========================[[[throws]]] exception is :" + ex.getMessage());
	}
	
	
}
