package com.thd.thread.api.t04lock.t02;

public class T01 {
	
	public static void main(String[] args) {
		Counter ct = new Counter();
		Thread t01 = new Thread(new Thread01(ct,"add"));
		Thread t02 = new Thread(new Thread01(ct,"substract"));
		

		t01.start();
		t02.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ct.exit();
		
		/**
		 * 本例验证了静态同步方法和使用synchronized(XX.class)其实锁的都是类
		 * 结果为
			add1
			add2
			add3
			add4
			add5
			add6
			add7
			add8
			add9
			
			或
			
			substract-1
			substract-2
			substract-3
			substract-4
			substract-5
			substract-6
			substract-7
			substract-8
			substract-9
			substract-10
		 * 
		 * 结果中没有出现在同步快中两个方法切换打印的结果,验证该结论的正确
		 * 
		 */
		

	}

}
