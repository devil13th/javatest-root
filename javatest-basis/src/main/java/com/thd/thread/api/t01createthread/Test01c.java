package com.thd.thread.api.t01createthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test01c {

	public static void main(String[] args) {
		 //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Web1230601b web1230601b = new Web1230601b();
        for(int i =0;i<5;i++){
            //为线程池分配任务
            executorService.submit(web1230601b);
        }
        //关闭线程池
        executorService.shutdown();
        
        System.out.println("线程执行完毕");

	}

}
