package com.thd.thread.test01;
/**
 * 通过实现Runnable接口创建线程
 * @author thd
 *
 */
public class ThreadTest0101 implements Runnable {

	public void run() {
		System.out.println("Hello from a thread!");
	}

	public static void main(String args[]) {
		(new Thread(new ThreadTest0101())).start();
	}
}
