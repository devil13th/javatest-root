/** 
 * Class Description:########
 * Date : 2018年3月22日 上午11:29:05
 * Auth : ccse 
*/  

package com.thd.jvm.classloaded;

public class T01 {
	static int x =1 ;
	static{
		x = 2;
		System.out.println("加载 类 T01");
	}
	public static void main(String[] args){
		System.out.println("main()...");
		//创建数组并不会初始化数组的元素类型
		Son[] ss = new Son[5];
		System.out.println("创建数组完成");
		//第一次加载Son类,加载时首先要看其父类是否已加载过,如果没有加载,则先加载父类
		Son s = new Son();
		
		Son s2 = new Son();
		System.out.println("finish");
		
		
		
	}
}


class Father{
	
	//只在类初始化的时候(第一次加载(引用))的时候运行
	static{
		System.out.println("加载 类 Father - 只执行一次"); 
	}
	
	private String name;
	
	public  Father(){
		System.out.println("Father 实例化");
	}
	
	
}

class Son extends Father {
	//只在类初始化的时候(第一次加载(引用))的时候运行
	static{
		System.out.println("加载 类 Son");
	}
	
	public Son(){
		System.out.println("Son 实例化");
	}
	
}