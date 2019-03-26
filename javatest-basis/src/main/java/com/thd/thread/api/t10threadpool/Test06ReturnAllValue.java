package com.thd.thread.api.t10threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import com.thd.thread.api.t01createthread.Web1230601b;

public class Test06ReturnAllValue {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		
		for(int i = 0 , j = 18 ; i < j ; i++){
			Thread02 t = new Thread02(i);
	        //1.执行 Callable 方式，需要 FutureTask 实现类的支持，用于接收运算结果。
	        FutureTask<String> result = new FutureTask<String>(t);
			
			es.submit(result);
			
			try {
				//调用futureTask.get()方法会阻塞线程,直到获取到结果
				System.out.println(result.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
