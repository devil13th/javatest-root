package com.thd.thread.syn.test01;

public class TextThread {
	public static void main(String[] args) {
		// TODO 自动生成方法存根
		TxtThread tt = new TxtThread();
		new Thread(tt).start();
		new Thread(tt).start();
		new Thread(tt).start();
		new Thread(tt).start();
	}

}

class TxtThread implements Runnable {
	int num = 100;
	String str = new String();

	public void run() {
		//注释掉synchronized  输出很混乱,每个线程之间出现交替输出   加上synchronized则按顺序输出
		synchronized (str) {
			for(int i=0 ; i < 10 ; i++){
				if (num > 0) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						e.getMessage();
					}
					System.out.println(Thread.currentThread().getName()+ "this is " + num--);
				}
			}
		}
	}
}
