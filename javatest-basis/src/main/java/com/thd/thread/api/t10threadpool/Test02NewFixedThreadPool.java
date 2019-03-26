package com.thd.thread.api.t10threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test02NewFixedThreadPool {
	/**
	 * 创建一个线程数量是固定大小的线程池newFixedThreadPool
	 * 最多同时运行固定大小的任务,如果再有新任务则进入等待队列,
	 * 等运行的任务完成后,等待队列中的任务才会被执行(排队上厕所一样,出来一个后才能进来一个)
	 *
	 * 
	 */
	public static void main(String[] args) {
		//创建一个核心线程为3的固定大小线程池
		//最多有3个线程同时运行,如果再有新的线程进入必须等待
		//3个同时运行的线程中有运行完成的在去执行等待的线程
		//过程如下
		/**
		 * 任务1进入线程池,线程池中有3个空闲线程(线程1,线程2,线程3),用线程1执行任务1
		 * 任务2进入线程池,线程池中有2个空闲线程(线程2,线程3),用线程2执行任务2
		 * 任务3进入线程池,线程池中有1个空闲线程(线程3),用线程3执行任务3
		 * 任务4进入线程池,线程池中没有空闲线程,任务4等待
		 * 任务5进入线程池,线程池中没有空闲线程,任务5等待
		 * 任务1结束,线程1闲置
		 * 线程1执行任务4
		 * 任务2结束,线程2闲置
		 * 线程2执行任务5
		 */
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		for(int i = 0 , j = 18 ; i < j ; i++){
			Thread t = new Thread(new Thread01(i),"thread" + i);
			
			es.execute(t);
		}

	}

}
