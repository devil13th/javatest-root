/** 
 * Class Description:########
 * Date : 2018年4月4日 上午10:05:46
 * Auth : ccse 
*/  

package com.thd.jvm.gc.refreneceType;

public class RefreneceType {
	public void test01(){
		//强引用
		User u1 = new User("张三",5);
		
		System.gc();
		
		u1 = null;
		System.gc();
	}
	
	public static void main(String args[]){
		
		/**
		 * JVM参数：-XX:+PrintGC  -XX:+PrintGCDetails  -Xloggc:d:/gc.log
		 */
		RefreneceType rt = new RefreneceType();
		rt.test01();
		System.out.println("finish");
		
	}
}
