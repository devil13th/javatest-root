package com.thd.thread.objectlock.t01;

public class Room implements Runnable{
	public Room() {
		
	}
	public String toString() {
		return " Room Object ... ";
	}
	
	public void run() {
		this.sleep();
	}
	synchronized public void sleep() {
		for(int i = 0 , j = 5 ; i < j ; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(" 睡觉 " + this.toString());
		}
	}
	
	public void work() {
		synchronized(this) {
			for(int i = 0 , j = 5 ; i < j ; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" 工作 " + this.toString());
			}
		}
	}
}
