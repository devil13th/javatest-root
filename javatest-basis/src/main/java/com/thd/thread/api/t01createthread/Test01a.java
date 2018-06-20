package com.thd.thread.api.t01createthread;

public class Test01a {

	public static void main(String[] args) {
		//Web12306通过继承Thread创建线程 -- 不推荐 原因1.Java单继承   2.资源紧张
		Web1230601a w = new Web1230601a();
		Thread t = new Thread(w,"张三");
		t.start();

	}

}
