package com.thd.thread.api.t02sleep.t01;

public class Test02 {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Web1230602(),"张三");
		System.out.println("Start ... ");
		Thread.sleep(1000);
		t.start();
	}
}
