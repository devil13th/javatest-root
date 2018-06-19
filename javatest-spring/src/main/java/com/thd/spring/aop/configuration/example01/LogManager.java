package com.thd.spring.aop.configuration.example01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
//这个类是一个切面汇总了(aspect),一个关注点的模块化，这个关注点可能会横切多个对象
public class LogManager {
	public void saveLog(JoinPoint jp){
		System.out.println(" ========================= log begin ==========================");
		Object[] args = jp.getArgs();//获取joinpoint的参数(add*() del*() 方法的参数) 
		Object obj = jp.getThis();//获取被代理的对象 (UserManagerImpl)
		System.out.println(obj);
		System.out.println(args[0]);  
        System.out.println(" ========================= log end ========================= ");  
	}
	
	
	public Object timeLog(ProceedingJoinPoint  pjp) throws Throwable{
		long begin = System.nanoTime();   
		Object o = pjp.proceed();
        long end = System.nanoTime();  
        System.out.println(pjp.getTarget().getClass()+"."+pjp.getSignature().getName() + " 执行 " + pjp.getSignature().getName() +"方法所用时间：" + (end-begin)/1000000);  
        return o;    
	}
}
