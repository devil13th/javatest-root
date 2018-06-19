package com.thd.thread.methodlock.t03;

public class T03 {

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
		 * com.thd.Thread.methodlock.t03.Creator@5bf9e914
		 * com.thd.Thread.methodlock.t03.Creator@768a67ee
		 * 
		 * 单例模式创建除了2个实例
		 * 
		 */
	}

}
