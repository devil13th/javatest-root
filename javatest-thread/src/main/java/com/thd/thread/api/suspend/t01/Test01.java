package com.thd.thread.api.suspend.t01;

public class Test01 {

	public static void main(String[] args) throws Exception{
		MyThread myThread = new MyThread();
		myThread.start();
		Thread.sleep(1000);
		
		myThread.suspend();
		
		System.out.println("A=" + System.currentTimeMillis() + " i=" + myThread.getI());
		Thread.sleep(1000);
		System.out.println("A=" + System.currentTimeMillis() + " i=" + myThread.getI());
		
		myThread.resume();
		
		Thread.sleep(1000);
		
		myThread.suspend();
		System.out.println("A=" + System.currentTimeMillis() + " i=" + myThread.getI());
		myThread.sleep(1000);
		System.out.println("A=" + System.currentTimeMillis() + " i=" + myThread.getI());
		myThread.resume();
		myThread.sleep(1000);
		System.out.println("A=" + System.currentTimeMillis() + " i=" + myThread.getI());
		
	}
	/**
	 * 运行结果：
A=1525187742122 i=455951545
A=1525187743123 i=455951545
A=1525187744126 i=917007699
A=1525187745129 i=917007699
A=1525187746134 i=1371543989

	 *  可以看出来，线程被暂停和恢复了
	 */

}

class MyThread extends Thread {
	private long i = 0;
	public long getI() {
		return i;
	}
	public void setI(long i ) {
		this.i = i;
	}
	public void run() {
		while(true) {
			i++;
		}
	}
}