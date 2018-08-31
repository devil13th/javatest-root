package com.thd.thread.methodlock.t04;

public class T04 {

	public static void main(String[] args) {
		Operate a1 = new Operate("A");
		Operate a2 = new Operate("B");
		Thread t1 = new Thread(a1);
		Thread t2 = new Thread(a2);
		
		t1.start();
		t2.start();
		/**
		 * 输出结果：
		 * A create 
		 * B create 
		 * com.thd.Thread.methodlock.t04.Creator@29d3da56
		 * com.thd.Thread.methodlock.t04.Creator@29d3da56
		 * 
		 * Creator.getInstance方法加上synchronized修饰后可以了
		 * 
		 */
	}

}
