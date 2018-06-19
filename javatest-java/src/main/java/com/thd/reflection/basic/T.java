package com.thd.reflection.basic;

import java.lang.reflect.Constructor;


public class T {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		Class c = Class.forName("com.thd.reflection.basic.User");
		//无参数构造函数
		Object obj = c.newInstance();
		User u = (User)obj;
		System.out.println(u);
		System.out.println("==============");
		
		//有参数构造函数
		User u2 = (User)c.getConstructor(String.class).newInstance("张三");
		System.out.println(u2.getName());
		System.out.println("==============");
		
		
		//有参数构造函数
		User u3 = (User)c.getConstructor(String.class,Integer.class).newInstance("张三",5);
		System.out.println(u3.getName() +"|"+ u3.getAge());
	}

}
