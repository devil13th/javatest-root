package com.thd.thread.api.t12threadlocal.threadlocal;

import java.util.HashMap;

public class Thread01 implements Runnable {
	
	@Override
	public void run() {
		//ThreadVar.mtl是自定义带有初始值的ThreadLocal
		System.out.println(Thread.currentThread().getName() + " 线程初始化的MyThreadLocal为" + ThreadVar.mtl.get());
		ThreadVar.tdm.set(new HashMap<String,Integer>());
		for(int i = 0 , j = 5 ; i < j ; i++){
			ThreadVar.tds.set(Thread.currentThread().getName() + "_" + i);
			System.out.println(ThreadVar.tds.get());
			ThreadVar.tdm.get().put((Thread.currentThread().getName() + "_" + i),Integer.valueOf(i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(ThreadVar.tdm.get());
		ThreadVar.tdm.remove();
	}
}
