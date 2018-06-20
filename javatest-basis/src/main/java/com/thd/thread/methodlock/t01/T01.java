package com.thd.thread.methodlock.t01;


public class T01 {

	public static void main(String[] args) {
		Count01 ct = new Count01();
		CountOperate co1 = new CountOperate("a",ct);
		CountOperate co2 = new CountOperate("b",ct);
		
		Thread t1 = new Thread(co1);
		Thread t2 = new Thread(co2);
		
		t1.start();
		t2.start();
		/**
		 * 输出结果如下
		 * method add +  
		 * method add -  
		 * method divid +
		 * 
		 * method add + 输出后等了3秒后才输出下面的内容,说明synchronized在方面前面锁的是对象,
		 * 否则"method divid"会立即输出
		 * 
		 * 如果去掉Count01.divid前的synchronized则"method divid"会立即输出 
		 * 
		 * 
		 * 
		 */
	}

}
