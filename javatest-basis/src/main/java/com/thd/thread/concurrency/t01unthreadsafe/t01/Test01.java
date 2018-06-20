package com.thd.thread.concurrency.t01unthreadsafe.t01;

public class Test01 {

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
		 * a set over !
		 * b set over !
		 * b num=200
		 * a num=200
		 *
		 * 出现了脏读
		 */
	}

}
