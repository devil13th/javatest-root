package com.thd.thread.api.t11state;

public class Thread01 implements Runnable {
	private int name;
	public Thread01(int i){
		this.name = i;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0 , j = 10 ; i < j ; i++){
			System.out.println(Thread.currentThread().getName() + ":" + this.name + ":" + Thread.currentThread().getState());
		}
		
		try {
			this.wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
