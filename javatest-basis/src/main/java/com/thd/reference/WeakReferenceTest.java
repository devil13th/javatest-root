package com.thd.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
	/**
	 * 软引用的对象在发生gc的时候会被回收  
	 * 例子中变量a引用的字符串对象 会在垃圾回收的时候被回收
	 * 因为没有强引用引用了(后续代码？)
	 * 
	 * 
	 * 加入下面的参数来记录gc
	 * jvm args ：-XX:+PrintGCDetails -Xloggc:D:/deleteme/app_gc.log 
	 * 
	 * 如果久久不能回收,使用jconsole进行手工垃圾回收
	 */
	public static void main(String[] args){
		String a = new String("1234");
		WeakReference<String> wr = new WeakReference<String>(a);
		while(true){
			if(wr.get() != null){
				System.out.println(" 变量a引用的对象还活着 ");
			}else{
				System.out.println(" 变量a引用的对象已被回收 ");
			}
		}
	}
}
