package com.thd.thread.api.t02sleep.t03;

import java.util.ArrayList;
import java.util.List;

public class Test03 {

	public static void main(String[] args) {
		Integer a = 1;
		ThreadLock tl = new ThreadLock(a);
		
		ThreadLockThread tlt1 = new ThreadLockThread(tl,"a");
		Thread t1 = new Thread(tlt1);
		
		ThreadLockThread tlt2 = new ThreadLockThread(tl,"b");
		Thread t2 = new Thread(tlt2);
		
		
		t1.start();
		t2.start();
		
		System.out.println("finish");
	}

}
