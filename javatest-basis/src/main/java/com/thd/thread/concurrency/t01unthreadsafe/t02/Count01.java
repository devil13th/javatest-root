package com.thd.thread.concurrency.t01unthreadsafe.t02;

public class Count01 {
	private int num;

	synchronized public void add(String name) {
		try {
			if ("a".equals(name)) {
				num = 100;
				System.out.println("a set over !");
				Thread.sleep(2000);
			} else {
				num = 200;
				System.out.println("b set over !");
			}
			System.out.println(name+ " num=" + num);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
