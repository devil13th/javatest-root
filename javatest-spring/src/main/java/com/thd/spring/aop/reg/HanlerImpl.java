package com.thd.spring.aop.reg;

import org.aspectj.lang.JoinPoint;

public class HanlerImpl implements Handler {
	public void handler(JoinPoint jp){
//		System.out.println(" ========================= handler begin ==========================");
//		Object[] args = jp.getArgs();//获取joinpoint的参数(add*() del*() 方法的参数) 
//		Object obj = jp.getThis();//获取被代理的对象 (UserManagerImpl)
//		System.out.println(obj);  
//		System.out.println(args[0]);
//        System.out.println(" ========================= handler end ========================= ");  
		System.out.println("========= handler =======");
	}
}
