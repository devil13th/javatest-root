package com.thd.basic.datatype;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;

public class MapTest extends TestCase {
	@Test
	public void test02(){
		Map ht = new HashMap();
		ht.put("a", "a");
		ht.put("b", "b");
		ht.put("c", "c");
		ht.put(null,"d");
		ht.put(null,"e");
		ht.put("d", null);  
		
		System.out.println(ht.get(null));
		
		
	}
	@Test
	public void test01(){
		Map ht = new Hashtable();
		ht.put("a", "a");
		ht.put("b", "b");
		ht.put("c", "c");
		//ht.put(null,"d");   //编译报错,hashtable的key和value都不能是null!!
		//ht.put("d", null);  //编译报错,hashtable的key和value都不能是null!!
		
	}
}
