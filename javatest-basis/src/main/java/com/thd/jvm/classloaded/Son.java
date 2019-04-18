package com.thd.jvm.classloaded;

public class Son extends Father{
	//只在类初始化的时候(第一次加载(引用))的时候运行
		static{
			System.out.println("加载 类 Son - 只执行一次");
		}
		
		public Son(){
			System.out.println("Son 实例化");
		}
		
}
