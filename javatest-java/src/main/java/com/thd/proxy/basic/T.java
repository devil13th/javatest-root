package com.thd.proxy.basic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.thd.proxy.UserManager;
import com.thd.proxy.UserManagerImpl;

public class T {

	public static void main(String[] args) {
		Object target = new UserManagerImpl();
		InvocationHandler handler = new UserManagerInvocationHandler(target);
		UserManager um = (UserManager)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
		um.addUsr("devil13th");
	}

}
