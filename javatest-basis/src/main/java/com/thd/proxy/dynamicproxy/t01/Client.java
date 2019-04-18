package com.thd.proxy.dynamicproxy.t01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class Client {
	public static void main(String args[]){
		People t = new Teacher();
		InvocationHandler cp = new CustomProxy(t);
		People pxy = (People)Proxy.newProxyInstance(cp.getClass().getClassLoader(), t.getClass().getInterfaces(), cp);
		pxy.prt();
		
		
	}
}
