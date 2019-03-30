package com.thd.thread.api.t04lock.t01;

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
		 * 本例验证了同步方法和使用synchronized(this)其实锁的都是对象
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
		 * 可以将Counter中synchronized(this)更换为synchronized(lock)后再次运行,观看查询结果
		 * 
			substract-1
			add-1
			add-1
			substract-2
			substract-2
			add-2
			substract-1
			add-1
			add0
			substract-1
			substract-1
			add-1
			substract0
			add0
			add0
			substract0
			substract-1
			add-1
			substract-2
			add-2
		 * 
		 * 
		 * 
		 * 
		 */
		

	}

}
