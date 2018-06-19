package com.thd.spring.aop.configuration.example01;

import org.aspectj.lang.JoinPoint;

public class SecurityHandler {
	public void sercurityCheck(JoinPoint joinPoint) {//安全性检查 advice    
		System.out.println(" ========================= security begin ========================= ");
        Object[] args = joinPoint.getArgs();//获取joinpoint的参数(save*() del*() 方法的参数)  
        System.out.println(args[0]);  
        System.out.println("security check()");  
        System.out.println(" ========================= security end ========================= ");
    }  
}
