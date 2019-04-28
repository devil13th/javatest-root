package com.thd.thread.interview.test01;

public class Test01 {
	/**
	 * 某个线程在其他线程执行完后再执行 (Object.wait()方法实现)
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(" ---- begin ----");
		Count ct = new Count();
		
		
		Runnable lastWork = new LastWorker(ct,2);
		Thread th03 = new Thread(lastWork,"LastWorker");
		th03.start();
		
		
		Runnable workA = new Worker(ct);
		Runnable workB = new Worker(ct);
		
		Thread th01 = new Thread(workA,"WorkA");
		Thread th02 = new Thread(workB,"WorkB");
		th01.start();
		th02.start();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		

	}

}
