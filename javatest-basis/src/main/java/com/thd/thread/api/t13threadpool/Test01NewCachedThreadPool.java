package com.thd.thread.api.t13threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test01NewCachedThreadPool {
	/**
	 * 创建一个不限线程数上限的线程池newCachedThreadPool，任何提交的任务都将立即执行
	 * 执行前会先检查之前创建的线程是否有空闲(已经执行完任务的线程),如果有直接使用,如果没有则创建
	 * 
	 */
	public static void main(String[] args) {
		ExecutorService es = Executors.newCachedThreadPool();
		
		for(int i = 0 , j = 1000 ; i < j ; i++){
			Thread t = new Thread(new Thread01(i),"thread" + i);
			
			//打印出来的thread名称是线程池自己的名称 ,线程名称中并没有第999(pool-1-thread-999)个
			//因为在运行过程中虽然不断创建线程执行新的任务,
			//但也会有之前创建的线程完成了任务转为空闲线程,
			//这些空闲的线程会被复用 
			//过程如下：
			
			/*
			 * 任务1进到线程池中,查看线程池中是否有空闲线程,没有,则创建线程1
			 * 任务2进到线程池中,查看线程池中是否有空闲线程,没有,则创建线程2
			 * 任务3进到线程池中,查看线程池中是否有空闲线程,没有,则创建线程3
			 * 任务1运行完成,释放线程1
			 * 任务2运行完成,释放线程2
			 * 任务4进到线程池中,查看线程池中是否有空闲线程,有,则复用线程1
			 * 任务5进到线程池中,查看线程池中是否有空闲线程,有,则复用线程2
			 * ...
			 * 
			 */
			es.execute(t);
		}

	}

}
