package com.thd.basic.datatype;

import junit.framework.TestCase;

import org.junit.Test;

public class TestString extends TestCase {
	@Test
	public void test01() {
		String a = "aaa";
		String b = "aaa";
		System.out.println(a == b);
		
		String c = new String("ccc");
		String d = new String("ccc");
		System.out.println(a == b);
		
		String e = "eee";
		String f = new String("eee");
		System.out.println(e == f);
	}
}
