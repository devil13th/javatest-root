package com.thd.thread.api.t12threadlocal.inheritablethreadlocal;

public class ThreadVar {
	//可以继承父线程的ThreadLocal
	public static InheritableThreadLocal<String> itl = new InheritableThreadLocal<String>();
}
