package com.thd.thread.classlock.t04;

public class Service {

	public Service() {
		// TODO Auto-generated constructor stub
	}
	
	synchronized public static void printA() {
		System.out.println("线程[" + 
				Thread.currentThread().getName() + 
				"] 在 [" + 
				System.currentTimeMillis() + 
				"] 进入了 printA()"  
              );
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("线程[" + 
				Thread.currentThread().getName() + 
				"] 在 [" + 
				System.currentTimeMillis() + 
				"] 离开了 printA()"  
              );
	}
	
	public void printB() {
		synchronized(Service.class) {
			System.out.println("线程[" + 
								Thread.currentThread().getName() + 
								"] 在 [" + 
								System.currentTimeMillis() + 
								"] 进入了 printB()"  
		                      );
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("线程[" + 
					Thread.currentThread().getName() + 
					"] 在 [" + 
					System.currentTimeMillis() + 
					"] 离开了 printB()"  
	              );
		}
	}

}
