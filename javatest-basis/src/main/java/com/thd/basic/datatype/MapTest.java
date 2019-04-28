package com.thd.basic.datatype;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

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
	@Test
	public void test03(){
		long begin = System.currentTimeMillis();
		
		Map m = new TreeMap();
		for(int i = 0 , j = 999999 ; i < j ; i++){
			//System.out.println(i);
			if( i / 100000 == 0){
				m.put(String.valueOf(i/100000), i);
			}else{
				m.put(String.valueOf(Math.random()), i);
			}
		}
		long record = System.currentTimeMillis();
		System.out.println(begin);
		System.out.println(record);
		System.out.println((record - begin));
		
		/*
		Set<Entry> es = m.entrySet();
		Iterator<Entry> iter = es.iterator();
		while(iter.hasNext()){
		
			Entry et = iter.next();	
			System.out.println(et.getKey());
		}*/
	}
	
	
	
	@Test
	public void test04(){
		long begin = System.currentTimeMillis();
		
		Map m = new HashMap();
		for(int i = 0 , j = 999999 ; i < j ; i++){
			//System.out.println(i);
			if( i / 100000 == 0){
				m.put(String.valueOf(i/100000), i);
			}else{
				m.put(String.valueOf(Math.random()), i);
			}
		}
		long record = System.currentTimeMillis();
		System.out.println(begin);
		System.out.println(record);
		System.out.println((record - begin));
		
		/*
		Set<Entry> es = m.entrySet();
		Iterator<Entry> iter = es.iterator();
		while(iter.hasNext()){
		
			Entry et = iter.next();	
			System.out.println(et.getKey());
		}*/
	}
	
}
