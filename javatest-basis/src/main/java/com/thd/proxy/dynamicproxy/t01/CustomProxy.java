package com.thd.proxy.dynamicproxy.t01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomProxy implements InvocationHandler {
	
	private Object target;
	public CustomProxy(Object target){
		this.target =  target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("执行方法前");
		Object result =  method.invoke(target, args);
		System.out.println("执行方法后");
		return result;
	}

}
