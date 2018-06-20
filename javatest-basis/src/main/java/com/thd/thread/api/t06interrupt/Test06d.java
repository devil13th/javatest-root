package com.thd.thread.api.t06interrupt;

public class Test06d {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Web1230606a(),"张三");
		t.start();
		Thread.sleep(5000);
		t.interrupt();//标记t线程为停止状态
		
	}

}
