package com.thd.thread.api.t13threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Test06ReturnAllValue {
	public static void main(String[] args) {
		/**
		 * 测试多个线程同时执行时返回值
		 */
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		//创建一个睡1000毫秒后会有返回值的线程
		Thread03 ta = new Thread03(3000);
		//创建一个睡3000毫秒后会有返回值的线程
		Thread03 tb = new Thread03(1000);
		
		FutureTask<String> ft1 = new FutureTask<String>(ta);
		FutureTask<String> ft2 = new FutureTask<String>(tb);
		long begin = System.currentTimeMillis();
		es.submit(ft1);
		es.submit(ft2);
		
		//关闭线程池,不会当时关闭,等线程池中的线程执行完毕后才会关闭
		es.shutdown();
		//立刻关闭线程池,无论是否线程池中的线程是否执行完毕
		//es.shutdownNow();
		try {
			System.out.println(ft1.get());
			long end = System.currentTimeMillis();
			System.out.println((end-begin)/1000);
			System.out.println(ft2.get());
			end = System.currentTimeMillis();
			System.out.println((end-begin)/1000);
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
