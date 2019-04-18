package com.thd.basic.datatype;

import junit.framework.TestCase;

import org.junit.Test;

public class StringTest extends TestCase{
	@Test
	public void test01(){
		String a = "hello";
		String b = "hello";
		System.out.println(a==b); 
		
		/**
		 * true
		 * 在加载的时候 会先把类中的字符串字面量放到  然后让a和b指向该地址
		 * ==操作符如果对比的是对象,则是对比两个对象的地址是否相同(如果是基础类型则比较的是值)
		 */
	}
	
	@Test
	public void test02(){
		String a = new String("hello");
		String b = new String("hello");
		System.out.println(a==b); //false
		System.out.println(a.equals(b)); //true
		
		/**
		 * a和b是两个对象,因为new 操作符会创建新对象并分配内存空间,
		 * ==操作符如果对比的是对象,则是对比两个对象的地址是否相同(如果是基础类型则比较的是值)
		 * 
		 * equals如果没有被重写则是使用Object.equals方法,该方法就是返回的==结果,
		 * 但是String重写了equals方法,是根据字节数组一个一个比较,所以a.equals(b) 是 true
		 * 
		 */
	}
	
	
	@Test
	public void test03(){
		String a = "hello";
		String b = new String("hello");
		System.out.println(a==b); //false
		System.out.println(a.equals(b)); //true
		
		/**
		 * a 直接指向常量池中"abc"的地址
		 * b 指向的是堆中的new String("...")的内存地址,而该内存中又有一个指向常量池"abc"的地址
		 */
	}

}
