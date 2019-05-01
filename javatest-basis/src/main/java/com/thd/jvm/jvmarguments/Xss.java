package com.thd.jvm.jvmarguments;

import java.util.concurrent.TimeUnit;

public class Xss implements Runnable{
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " start");
		byte[] b = new byte[5 * 1024 * 1024]; // 500M的数组
		while(true){
			try {
				TimeUnit.MINUTES.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		/**
		 * jvm参数:-Xmx1024m -Xms1024m -Xmn512m -Xss256k -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d:/a.dump”  ——Java运行参数(转)
		 */
		int i = 0;
		while(true){
			try{
				
			
				Thread t = new Thread(new Xss(),"T"+i);
				t.start();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				i++;
			}catch(Exception e){
				System.out.println("执行了" + i + "个线程");
			}
		}
	}

}

