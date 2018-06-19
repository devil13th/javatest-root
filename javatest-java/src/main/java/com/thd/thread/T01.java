package com.thd.thread;

import java.util.Date;

public class T01 implements Runnable{
	
	private int ct = 1;
	private String name ;
	
	public T01(String name){
		this.name = name;
		
	}
	public void run() {
		try{
			Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		for(int i = 0 , j = 10 ; i < j ; i++){
			double l = Math.random();
			System.out.println("================" + l);
			System.out.println(l+"|"+this.name + "|" + ct++);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		T01 t01 = new T01("a");
        Thread t1 = new Thread(t01);
        Thread t2 = new Thread(t01);
        t1.start();
        t2.start();
        System.out.println("finish");
	}

}
