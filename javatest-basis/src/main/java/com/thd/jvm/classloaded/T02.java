/** 
 * Class Description:########
 * Date : 2018年3月22日 下午3:08:48
 * Auth : ccse 
*/  

package com.thd.jvm.classloaded;

public class T02 {

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println(System.getProperty("java.class.path"));
		System.out.println(T02.class.getClassLoader());
		
		Class c = T02.class.getClassLoader().loadClass("com.thd.jvm.classloaded.T01");
		System.out.println(c);
		System.out.println("###############################");
		System.out.println(Math.class.getClassLoader());
		char a = '\u00BA';
		System.out.println(a);
		
	}

}


class A{
	
	//只在类初始化的时候(第一次加载(引用))的时候运行
	static{
		System.out.println("加载 类 A - 只执行一次"); 
	}
	
	private String name;
	
	public  A(){
		System.out.println("A 实例化");
	}
	
	
}