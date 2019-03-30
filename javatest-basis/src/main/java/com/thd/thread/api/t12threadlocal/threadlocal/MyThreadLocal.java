package com.thd.thread.api.t12threadlocal.threadlocal;

/**
 * 定义一个ThreadLocal
 * 该ThreadLocal可以通过实现initialValue()方法初始化自定义的ThreadLocal的值
 * @author devil13th
 *
 */
public class MyThreadLocal extends ThreadLocal<String>{

	@Override
	protected String initialValue(){
	    System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
	    return "init";
	}
		
}
