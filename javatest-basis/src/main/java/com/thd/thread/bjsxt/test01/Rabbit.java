/** 
 * Class Description:########
 * Date : 2018年3月21日 下午10:52:49
 * Auth : ccse 
*/  

package com.thd.thread.bjsxt.test01;

public class Rabbit extends Thread {

	@Override
	public void run() {
		for(int i = 0 , j = 10 ; i < j ; i++){
			System.out.println(Thread.currentThread().getName() + " 兔子 跑到第" + i + "步");
		}
	}
	
}
class Tortoise extends Thread {

	@Override
	public void run() {
		for(int i = 0 , j = 10 ; i < j ; i++){
			System.out.println(Thread.currentThread().getName() + " 乌龟 跑到第" + i + "步");
		}
	}
	
}