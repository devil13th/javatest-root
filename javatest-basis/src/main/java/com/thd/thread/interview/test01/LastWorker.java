package com.thd.thread.interview.test01;

public class LastWorker implements Runnable {
	private Count ct;
	private int i;
	public LastWorker(Count ct,int i){
		this.ct = ct;
		this.i = i;
	}
	@Override
	public void run() {
		synchronized(ct){
			while(ct.getI() != i ){
				System.out.println(" 等待: " + ct.getI() + " -- " + i);
				try {
					ct.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("--------- last worker running ----------");
			for(int i = 0  , j = 1000 ; i < j ; i++){
				System.out.println(Thread.currentThread().getName() + " : " + i);
			}
		}

	}

}
