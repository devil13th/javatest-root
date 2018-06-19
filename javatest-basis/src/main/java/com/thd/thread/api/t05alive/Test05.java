package com.thd.thread.api.t05alive;

public class Test05 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Start ... ");
		Thread t = new Thread(new Web1230605(),"张三");
		System.out.println("01.Thread is alive ? " + t.isAlive() );
		t.start();
		System.out.println("02.Thread is alive ? " + t.isAlive() );
		System.out.println("03.Main is alive ?" + Thread.currentThread().isAlive());
		
		Thread.sleep(12000);
		System.out.println("04.Thread is alive ? " + t.isAlive() );
		
		
		System.out.println("Main End ... ");

	}

}
