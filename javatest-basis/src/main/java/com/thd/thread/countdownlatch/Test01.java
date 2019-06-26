package com.thd.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Test01 {

	public static void main(String[] args) {
		int ct = 5 ;
		CountDownLatch cdl = new CountDownLatch(ct);
		
		for(int i = 0 ; i < ct ; i++){
			Thread t = new Thread(new Thread01(cdl));
			t.start();
		}
		try {
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" finish ");
		
	}

}
