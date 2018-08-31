package com.thd.thread.concurrency.t01unthreadsafe.t02;

public class Test01 {

	public static void main(String[] args) {
		/**
		 * 跟t01包下的代码相同，只不过Count01.add方法设置为了synchronized
		 */
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
		 * a num=100
		 * b set over !
		 * b num=200
		 * 
		 * 输出结果未出现脏读
		 * 
		 */
	}

}
