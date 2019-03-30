package com.thd.thread.api.t12threadlocal.threadlocal;

import java.util.Map;

public class ThreadVar {
	//定义一个类型为String的ThreadLocal
	public static ThreadLocal<String> tds = new ThreadLocal<String>();
	//定义一个类型为Map<String,Integer>的ThreadLocal
	public static ThreadLocal<Map<String,Integer>> tdm = new ThreadLocal<Map<String,Integer>>();
	//使用自定义的ThreadLocal,可以初始化该ThreadLocal的值
	public static ThreadLocal<String> mtl = new MyThreadLocal();
}
