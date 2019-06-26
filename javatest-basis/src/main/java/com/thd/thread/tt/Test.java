package com.thd.thread.tt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	public static void main(String[] args){
		
		ExecutorService p = Executors.newFixedThreadPool(16);
		
		long btime = System.currentTimeMillis();
		
		int num = 16;
		CountDownLatch cdl = new CountDownLatch(num);
		for(int i = 0 , j = num ; i < j ; i++){
			Thread t1 = new Thread(new Calculator(999999999,cdl));
			p.execute(t1);
			//t1.start();
		}
		
		
		
		try {
			cdl.await();
			p.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long etime = System.currentTimeMillis();
		
		System.out.println("finish");
		System.out.println("总时间：" + (etime - btime));
		System.out.println("==============================");
		long btime1 = System.currentTimeMillis();
		Thread ta1 = new Thread(new Calculator(999999999,cdl));
		Thread ta2 = new Thread(new Calculator(999999998,cdl));
		Thread ta3 = new Thread(new Calculator(999999997,cdl));
		Thread ta4 = new Thread(new Calculator(999999996,cdl));
		ta1.run();
		ta2.run();
		ta3.run();
		ta4.run();
		long etime1 = System.currentTimeMillis();
		System.out.println("finish");

		System.out.println("总时间：" + (etime1 - btime1));
	}
}
