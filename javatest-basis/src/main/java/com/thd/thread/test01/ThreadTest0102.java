package com.thd.thread.test01;
/**
 * 通过继承Thread创建线程
 * @author thd
 *
 */
public class ThreadTest0102 extends Thread {

	@Override
	public void run() {
		System.out.println("Hello from a thread!");  
	} 
	public static void main(String args[]) {  
        (new ThreadTest0102()).start();  
    }  

}
