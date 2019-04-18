package com.thd.thread.api.t11join.t01;

import java.util.HashMap;
import java.util.Map;

public class Test01 {

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		Map<String,Integer> ct = new HashMap<String,Integer>();
		for(int i = 0 , j = 5 ; i < j ; i++){
			Thread t = new Thread(new ThreadA(i * 1000,ct),"T" + i);
			t.start();
			try {
				//t.join() 后  main阻塞等待t运行完后在运行
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println(ct);
		long end = System.currentTimeMillis();
		System.out.println( (end - begin)/1000 );

	}

}
