/** 
 * Class Description:########
 * Date : 2018年3月21日 下午10:48:19
 * Auth : ccse 
*/  

package com.thd.thread.bjsxt.test02;

public class T{
	/**
	 * 线程创建的第二种方式  实现Runnable接口,实现run方法 -- 推荐
	 */
	public static void main(String[] args){
		Rabbit r = new Rabbit();
		Tortoise t = new Tortoise();
		
		Thread r01 = new Thread(r,"兔子");
		Thread t01 = new Thread(t,"乌龟");
		r01.start();
		t01.start();
		
		for(int i = 0 ; i < 10 ; i++){
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}
