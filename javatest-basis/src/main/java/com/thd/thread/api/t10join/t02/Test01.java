package com.thd.thread.api.t10join.t02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test01 {
	/**
	 * 主线程等待其他线程结束后汇总结果
	 * @param args
	 */
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		
		List<FutureTask<Integer>> l = new ArrayList<FutureTask<Integer>>();
		Map<String,Integer> ct = new HashMap<String,Integer>();
		for(int i = 0 , j = 5 ; i < j ; i++){
			FutureTask<Integer> ft = new FutureTask<Integer>(new ThreadA(i * 1000,ct));
			l.add(ft);
			Thread t = new Thread(ft,"T" + i);
			t.start();
			
			
			//t.join() 后  main阻塞等待t运行完后在运行  , 使用callable也可以做到,而且非阻塞,等到使用get方法时阻塞等待执行结果
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
		for(int i = 0 , j = l.size() ; i < j ; i++){
			try {
				Integer r = l.get(i).get();
				System.out.println(r);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		long end = System.currentTimeMillis();
		System.out.println( "总时间" + (end - begin)/1000 );

	}

}
