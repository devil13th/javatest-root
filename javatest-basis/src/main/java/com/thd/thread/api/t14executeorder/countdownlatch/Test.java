package com.thd.thread.api.t14executeorder.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Test {
	/**
	 * CountDownLatch类位于java.util.concurrent包下，
	 * 利用它可以实现类似计数器的功能。 
	 * 
	 * CountDownLatch latch = new CountDownLatch(2); 创建一个计数为2的计数器
	 * latch.countDown(); 会减1
	 * latch.await();会阻塞程序,直到计数器为0才往下执行
	 * 
	 * 比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，
	 * 此时就可以利用CountDownLatch来实现这种功能了。
	 * @param args
	 */
    public static void main(String[] args) {   
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                   Thread.sleep(3000);
                   System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                   latch.countDown();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
            };
        }.start();

        new Thread(){
            public void run() {
                try {
                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                    latch.countDown();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
            };
        }.start();

        try {
           System.out.println("等待2个子线程执行完毕...");
           //阻塞程序,直到计数为0才会往下执行
           latch.await();
           System.out.println("2个子线程已经执行完毕");
           System.out.println("继续执行主线程");
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
}