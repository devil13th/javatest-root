/** 
 * Class Description:########
 * Date : 2018年3月21日 下午10:48:19
 * Auth : ccse 
*/  

package com.thd.thread.bjsxt.test01;

public class T{
	/**
	 * 线程创建的第一种方式  继承Thread类,重写run方法 -- 不推荐,因为java是单继承
	 */
	public static void main(String[] args){
		Rabbit r = new Rabbit();
		Tortoise t = new Tortoise();
		
		r.start();
		t.start();
		
		for(int i = 0 ; i < 10 ; i++){
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}
