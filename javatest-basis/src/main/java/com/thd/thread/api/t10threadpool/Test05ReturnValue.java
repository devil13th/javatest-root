package com.thd.thread.api.t10threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import com.thd.thread.api.t01createthread.Web1230601b;
/**
 * 线程执行返回值,使用实现Callable的call方法来创建线程可以通过futureTask.get()来获取call方法的返回值
 * 但是调用futureTask.get()会阻塞线程,一直等待线程返回值
 * @author devil13th
 *
 */
public class Test05ReturnValue {
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
