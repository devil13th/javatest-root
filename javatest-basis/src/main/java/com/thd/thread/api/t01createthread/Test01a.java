package com.thd.thread.api.t01createthread;

public class Test01a {

	public static void main(String[] args) {
		//Web12306通过继承Thread创建线程 -- 不推荐 原因1.Java单继承   2.资源紧张
		/**
		 * 1、用实现Runnable接口的方法创建对象可以避免java单继承机制带来的局限；
		 * 2、用实现Runnable接口的方法，可以实现多个线程共享同一段代码(数据)；
		 */
		Web1230601a w = new Web1230601a();
		Thread t = new Thread(w,"张三");
		t.start();

	}

}
