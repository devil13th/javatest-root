package com.thd.thread.api.t06interrupt;

public class Test06a {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Web1230606(),"张三");
		t.start();
		Thread.sleep(1000);
		t.interrupt();//标记t线程为停止状态
		// 所指的是main线程 该方法是静态方法(Thread.interrapted())，判断当前正在执行的线程（此例子中是main线程）是否为停止状态 --false
		System.out.println("1.是否停止？"  + Thread.interrupted()); 
		System.out.println("2.是否停止？"  + Thread.interrupted());//所指的是t线程是否标记停止状态  --true
		
	}

}
