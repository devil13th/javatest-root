package com.thd.proxy.basic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserManagerInvocationHandler implements InvocationHandler {
	
	private Object target;
	
	public UserManagerInvocationHandler(Object target){
		this.target = target;
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return method.invoke(target, args);
	}

}
