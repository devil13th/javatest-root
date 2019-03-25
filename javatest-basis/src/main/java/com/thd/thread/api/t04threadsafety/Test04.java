package com.thd.thread.api.t04threadsafety;

public class Test04 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Alogin(),"Thread A");
		Thread t2 = new Thread(new Blogin(),"Thread B");
		
		t1.start();
		t2.start();
	}

}
