package com.thd.thread.api.threadExample.exam01;

public class T {

	public static void main(String[] args) {
		CountThread ct = new CountThread(100000);
		Thread t = new Thread(ct);
		t.start();
		while(t.isAlive()){
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ct.getL().size());
		}

	}

}
