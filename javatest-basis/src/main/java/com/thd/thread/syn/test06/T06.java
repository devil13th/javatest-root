/** 
 * Class Description:########
 * Date : 2018年3月20日 上午11:01:40
 * Auth : ccse 
*/  

package com.thd.thread.syn.test06;

public class T06 implements Runnable{
	private Count count;
	public T06(Count count){
		this.count = count;
	}
	public void run() {
		count.count();
	}
	
	
	public static void main(String[] args){
		Count ct = new Count();
		Thread t1 = new Thread(new T06(ct),"a01");
		Thread t2 = new Thread(new T06(ct),"a02");
		t1.start();
		t2.start();
		System.out.println("finish");
	}
}
