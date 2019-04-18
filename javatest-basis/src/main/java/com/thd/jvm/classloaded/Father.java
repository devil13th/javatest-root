package com.thd.jvm.classloaded;

public class Father {
public static String fatherName = "fatherName";
	
	public static String name = "fatherName";
	
	//只在类初始化的时候(第一次加载(引用))的时候运行
	static{
		System.out.println("加载 类 Father - 只执行一次"); 
		name = "fatherNameStatic";
	}
	
	
	public  Father(){
		System.out.println("Father " + Father.fatherName + " 实例化");
	}
	
	public void printName(){
	}
}
