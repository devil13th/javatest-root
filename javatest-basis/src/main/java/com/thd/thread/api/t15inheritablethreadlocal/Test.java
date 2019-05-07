package com.thd.thread.api.t15inheritablethreadlocal;
/**
 * 测试InheritableThreadLocal,
 * @author devil13th
 *
 */
public class Test {
	
	public static InheritableThreadLocal<String> itl = new InheritableThreadLocal<String>();
	public static ThreadLocal<String> tl = new ThreadLocal<String>();
	public static void main(String[] args) {
		
		//Test.itl.set("main 设置的 InheritableThreadLocal");
		Test.tl.set("main 设置的 ThreadLocal");
		Thread t1 = new Thread(new ThreadParent(),"parentA");
		Thread t2 = new Thread(new ThreadParent(),"parentB");
		t1.start();
		t2.start();
		
		System.out.println(Thread.currentThread().getName() + " inheritableThreadLocal:" + Test.itl.get());

		System.out.println(Thread.currentThread().getName() + " threadLocal:" + Test.tl.get());

	}

}
