package com.thd.thread.api.t07wait.t02;

public class Test02 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Test02 t2 = new Test02();
		Td td = new Td();
		Thread t = new Thread(td);
		t.start();
		
		
		t.join();
		System.out.println("1234");
		Thread.currentThread().sleep(4500);
		System.out.println("finish ...");
	}
	
	

}

class Td implements Runnable{
	synchronized public void run() {
		for(int i = 0 , j = 5 ; i < j ; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if( i == 3) {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(i);
		}
	}
}
