/** 
 * Class Description:########
 * Date : 2018年3月21日 下午11:04:22
 * Auth : ccse 
*/  

package com.thd.thread.bjsxt.test05;

public class Web12306 implements Runnable{
	private int ticketNum = 50;
	private boolean threadStatus = true;
	public void run(){
		while(threadStatus){
			synchronized(this){
				if(ticketNum <= 0){
					break;
				}
				System.out.println(Thread.currentThread().getName() + ":抢到了" +ticketNum--);
			}
			
		}
	}
	
	public void stop(){
		threadStatus = false;
	}
	
	/**
	 * 外部干涉线程停止(定义变量)
	 */
	public static void main(String[] args){
		Web12306 w = new Web12306();
		Thread t1 = new Thread(w,"张三");
		Thread t2 = new Thread(w,"李四");
		Thread t3 = new Thread(w,"王五");
		
		t1.start();
		t2.start();
		t3.start();
		
		
		for(int i = 0 ; i < 1000 ; i++){
			if(50==i){
				w.stop();
			}
			System.out.println(i);
		}
	}
	
}
