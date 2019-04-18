/** 
 * Class Description:########
 * Date : 2018年3月22日 上午11:29:05
 * Auth : ccse 
*/  

package com.thd.jvm.classloaded;

public class T01 {
	static{
		x = 2;
		System.out.println("加载 类 T01");
	}
	static int x =1 ;
	
	public static void main(String[] args){
		System.out.println("main() 方法开始...");
		//创建数组并不会初始化数组的元素类型
		Son[] ss = new Son[5];
		System.out.println("创建数组完成");
		//第一次加载Son类,加载时首先要看其父类是否已加载过,如果没有加载,则先加载父类
		Son s = new Son();
		
		Son s2 = new Son();
		System.out.println(T01.x);
		System.out.println(Father.name);
		System.out.println("finish");
		
		
		
	}
}

