package com.thd.thread.methodlock.t02;


public class T02 {

	public static void main(String[] args) {
		Count02 ct = new Count02();
		CountOperate co1 = new CountOperate("a",ct);
		CountOperate co2 = new CountOperate("b",ct);
		
		Thread t1 = new Thread(co1);
		Thread t2 = new Thread(co2);
		
		t1.start();
		t2.start();
		/**
		 * 如果线程出现异常，则会释放锁
		 * 所以t1线程出现异常后 t2.start();调用的run方法得以执行 
		 * 
		 * 
		 * 
		 */
	}

}
