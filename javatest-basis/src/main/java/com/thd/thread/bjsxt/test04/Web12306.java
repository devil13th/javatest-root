/** 
 * Class Description:########
 * Date : 2018年3月21日 下午11:04:22
 * Auth : ccse 
*/  

package com.thd.thread.bjsxt.test04;

public class Web12306 implements Runnable{
	private int ticketNum = 3;
	private boolean status = true;
	private Object obj = new Object();
	public void run(){
		while(status){
			test01();
		}
	}
	
	public void test01(){
		System.out.println(Thread.currentThread().getName()+"==");
		synchronized(obj){
			
			if(ticketNum <= 0){
				status = false;
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":抢到了" +ticketNum--);
		}
		
	}
	
	/**
	 * synchronized 加锁  解决资源共享冲突
	 * 
	 */
	public static void main(String[] args){
		Web12306 w = new Web12306();
		Thread t1 = new Thread(w,"张三");
		Thread t2 = new Thread(w,"李四");
		Thread t3 = new Thread(w,"王五");
		
		t1.start();
		t2.start();
		t3.start();
	}
	
}
