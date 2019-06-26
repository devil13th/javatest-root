package com.thd.thread.api.t14executeorder.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Test {
	/**
	 * 通过它可以实现让一组线程等待至某个状态之后再全部同时执行
	 * 用来挂起当前线程，直至所有线程都到达barrier状态再同时执行后续任务
	 * 
	 * 叫做回环是因为当所有等待线程都被释放以后，CyclicBarrier可以被重用。
	 * 我们暂且把这个状态就叫做barrier，当调用await()方法之后，线程就处于barrier了
	 * 
	 * 类似于一个可以复用的countdownlatch,当计数减到0后重新进行计数
	 * @param args
	 */
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier  = new CyclicBarrier(N);
        for(int i=0;i<N;i++)
            new Writer(barrier).start();
    }
    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
 
        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
            try {
				cyclicBarrier.await();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (BrokenBarrierException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            System.out.println("线程"+Thread.currentThread().getName()+"再次写入数据...");
            try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("所有线程第二次写入完毕，继续处理其他任务.....");
            
            
        }
    }
}