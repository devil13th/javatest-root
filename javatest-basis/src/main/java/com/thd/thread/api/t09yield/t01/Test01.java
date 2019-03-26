package com.thd.thread.api.t09yield.t01;

public class Test01 {

	public static void main(String[] args) {
		Thread thread = new Thread(new ThreadA());
		thread.start();
	}

}


class ThreadA implements Runnable{
	public void run() {
		long t1 = System.currentTimeMillis();
		for(int i = 0 , j = 100000 ; i < j ; i++) {
			System.out.println(i);
			Thread.yield();
		}
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}