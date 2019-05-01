package com.thd.thread.api.t10join.t01;

import java.util.HashMap;
import java.util.Map;

public class Test01 {
	public static void test01(){
		long begin = System.currentTimeMillis();
		Map<String,Integer> ct = new HashMap<String,Integer>();
		for(int i = 0 , j = 5 ; i < j ; i++){
			Thread t = new Thread(new ThreadA(i * 1000,ct),"T" + i);
			t.start();
			try {
				//t.join() 后  main阻塞等待t运行完后在运行
				// t1 t2 t3 因为开启后就join所以  t1,t2,t3会顺序执行
				
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println(ct);
		long end = System.currentTimeMillis();
		System.out.println( (end - begin)/1000 );
	}
	
	public static void test02() throws Exception{
		long begin = System.currentTimeMillis();
		Map<String,Integer> ct = new HashMap<String,Integer>();
		
		Thread t1 = new Thread(new ThreadA(2,ct),"T1");
		Thread t2 = new Thread(new ThreadA(2,ct),"T2");
		Thread t3 = new Thread(new ThreadA(2,ct),"T3");
		
		t1.start();
		t2.start();
		t3.start();
		// t1 t2 t3 因为开启后再join所以  t1,t2,t3会交替执行
		t1.join();
		t2.join();
		t3.join();
		
		
		
		System.out.println(ct);
		long end = System.currentTimeMillis();
		System.out.println( (end - begin)/1000 );
	}
	public static void main(String[] args) throws Exception {
		/**
		 * 比较test01和test02因为join的时机不同,导致运行结果不同
		 */
		test01();
		//test02();

	}

}
