package com.thd.spring.annotation.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
//该类是一个切面类
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspectJ {
	
	/**
	 * 一些常用的表达式
任意公共方法的执行：
execution(public * *(..))
任何一个以“set”开始的方法的执行：
execution(* set*(..))
AccountService 接口的任意方法的执行：
execution(* com.xyz.service.AccountService.*(..))
定义在service包里的任意方法的执行：
execution(* com.xyz.service.*.*(..))
定义在service包或者子包里的任意类的任意方法的执行：
execution(* com.xyz.service..*.*(..))
	 */
	@Pointcut("execution(* com.thd.spring.annotation.aop..*Service.*(..))")
	public void pointCut(){};
	
	@Before("pointCut()")
	public void before(JoinPoint joinPoint){
		System.out.println("before " + joinPoint.getTarget().getClass() + "." + joinPoint.getSignature().getName());
		Object[] args = joinPoint.getArgs();
		System.out.println(""+joinPoint.getSignature().getName()+"运行。。。@Before:参数列表是：{"+Arrays.asList(args)+"}");
	}
	@After("com.thd.spring.annotation.aop.MyAspectJ.pointCut()")
	public void after(JoinPoint joinPoint){
		System.out.println("after "  + joinPoint.getSignature().getName());
	}
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint pjp){
		try {
			System.out.println("around before "  + pjp.getSignature().getName());
			
			//Object o =  pjp.proceed();
			Object o =  pjp.proceed(pjp.getArgs());
			System.out.println("around after "  + pjp.getSignature().getName());
            return o;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}
	@AfterReturning(value="pointCut()",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		System.out.println("afterReturning " + joinPoint.getSignature().getName());
	}
	
	//注意：如果要开启@AfterThrowing 需要注释掉@Around标注的方法
	@AfterThrowing(value="pointCut()",throwing="exception")
	public void afterThrowing(JoinPoint joinPoint,Exception exception){
		System.out.println("afterThrowing "  + joinPoint.getSignature().getName());
		System.out.println(exception.getMessage());
	}
	
	
}
