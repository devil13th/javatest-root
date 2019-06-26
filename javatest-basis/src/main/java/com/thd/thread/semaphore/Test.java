package com.thd.thread.semaphore;

import java.util.concurrent.Semaphore;
//Semaphore 的作用是控制线程只能有指定数量的线程处于运行状态,如果存在更多的线程则阻塞
public class Test {
    public static void main(String[] args) {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(2); //机器数目
        for(int i=0;i<N;i++)
            new Worker(i,semaphore,i%2).start();
    }
 
    static class Worker extends Thread{
        private int num;
        private Semaphore semaphore;
        private int sleepTime;
        public Worker(int num,Semaphore semaphore,int sleepTime){
            this.num = num;
            this.semaphore = semaphore;
            this.sleepTime = sleepTime * 1000;
        }
 
        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一个机器在生产...");
                Thread.sleep(this.sleepTime);
                System.out.println("工人"+this.num+"释放出机器");
                semaphore.release();           
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}