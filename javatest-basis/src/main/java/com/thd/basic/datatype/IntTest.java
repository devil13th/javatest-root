package com.thd.basic.datatype;

import junit.framework.TestCase;

import org.junit.Test;

public class IntTest extends TestCase {
	@Test
	public void test01(){
		Integer a = Integer.valueOf(127);
		Integer b = Integer.valueOf(127);
		System.out.println(a == b); //true
		
		Integer c = Integer.valueOf(128);
		Integer d = Integer.valueOf(128);
		System.out.println(c == d); //false
		
		int e = 127;
		Integer f = new Integer(127);
		System.out.println(e == f);//true
		
		Integer g = new Integer(127);
		Integer h = new Integer(127);
		System.out.println(g == h);// false
		
		/**
		 * Integer.valueOf 源码:
		 * 
		 * public static Integer valueOf(int i) {  
		 *    if(i >= -128 && i <= IntegerCache.high)  
		 *        return IntegerCache.cache[i + 128];  
		 *    else  
		 *        return new Integer(i);  
		 * }  
		 * 
		 * -128 至  127 使用valueOf的时候返回的是基础类型,否则返回的是Integer对象
		 * 
		 * 
		 */
	}
	
	
	@Test
	public void test02(){
		
	}
}
