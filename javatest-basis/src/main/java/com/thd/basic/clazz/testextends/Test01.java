package com.thd.basic.clazz.testextends;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;
public class Test01 extends TestCase{
	@Test
	public void test01(){
		
		/**
		 * 父类的静态变量可以被继承,但是不能重写的   static在类加载的时候只加载一次
		 */
		Parent p = new Parent();
		System.out.println(p.parentStr); //parent
		Parent c = new Child();
		System.out.println(c.parentStr); //parent
		Child c1 = new Child();
		System.out.println(c1.parentStr); //child
	}
	
	
	
}
