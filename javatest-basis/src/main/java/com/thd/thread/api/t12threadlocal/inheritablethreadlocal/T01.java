package com.thd.thread.api.t12threadlocal.inheritablethreadlocal;

public class T01 {

	public static void main(String[] args) {
		Thread t = new Thread(new ThreadParent());
		t.setName("Parent Thread");
		t.start();
	}

}
