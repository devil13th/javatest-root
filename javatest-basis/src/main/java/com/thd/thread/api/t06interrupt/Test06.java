package com.thd.thread.api.t06interrupt;

public class Test06 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Web1230606(),"张三");
		t.start();
		Thread.sleep(2000);
		//interrupt()并不能暂停线程，而是做了一个暂停标记
		t.interrupt();

	}

}
