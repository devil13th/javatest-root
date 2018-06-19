package com.thd.java.map;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;

public class HashMapTest extends TestCase {
	@Test
	public void test01(){
		Map m = new HashMap();
		m.put(null, null);
		System.out.println(m.get(null));
	}
}
