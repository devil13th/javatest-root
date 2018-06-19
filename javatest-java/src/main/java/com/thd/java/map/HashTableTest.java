package com.thd.java.map;

import java.util.Hashtable;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;

public class HashTableTest extends TestCase {
	@Test
	public void test01(){
		Map m = new Hashtable();
		//不允许在key中放null
		m.put(null, null);
		System.out.println(m.get(null));
	}
}
