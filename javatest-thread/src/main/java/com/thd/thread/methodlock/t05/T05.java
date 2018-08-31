package com.thd.thread.methodlock.t05;

public class T05 {

	public static void main(String[] args) {
		int ct = 100;
		for(int i = 0 , j = ct ; i < j ; i++) {
			Operate a = new Operate("A" + i);
			Thread t = new Thread(a);
			
			t.start();
		}
		/**
		 * 
		 * 为了提高执行效率Creator.getInstance方法中加入了双重判断，使用了同步语句块
		 * 
		 */
	}

}
