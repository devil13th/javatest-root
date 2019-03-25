package com.thd.basic.container;

import java.util.Comparator;
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
	public void testTreeMap(){
		
		/**
		 * TreeMap取出来的是排序后的键值对。插入、删除需要维护平衡会牺牲一些效率。
		 * 但如果要按自然顺序或自定义顺序遍历键，那么TreeMap会更好
		 */
		Map<Integer,String> tree = new TreeMap<Integer,String>();
		tree.put(1, "1");
		tree.put(5, "5");
		tree.put(3, "3");
		tree.put(7, "7");
		tree.put(2, "2");
		tree.put(4, "4");
		tree.put(6, "6");
		tree.put(9, "9");
		tree.put(8, "8");
		tree.put(11, "11");
		tree.put(15, "15");
		tree.put(13, "13");
		tree.put(17, "17");
		tree.put(12, "12");
		tree.put(14, "14");
		tree.put(16, "16");
		tree.put(19, "19");
		tree.put(18, "18");
		tree.put(55, "55");
		tree.put(33, "33");
		tree.put(77, "77");
		tree.put(22, "22");
		tree.put(44, "44");
		tree.put(66, "66");
		tree.put(99, "99");
		tree.put(88, "88");
		System.out.println(tree);
		Set<Entry<Integer,String>> set = tree.entrySet();
		Iterator<Entry<Integer,String>> iter = set.iterator();
		while(iter.hasNext()){
			Entry<Integer,String> et = iter.next();
			System.out.println(et.getKey() + " | " + et.getValue());
		}
	}
	
	@Test
	public void testHashMap(){
		/**
		 * HashMap里面存入的键值对在取出的时候是随机的，它根据键的HashCode值存储数据,根据键可以直接获取它的值，具有很快的访问速度。
		 * 在Map 中插入、删除和定位元素，HashMap是最好的选择。
		 */
		Map<Integer,String> m = new HashMap<Integer,String>();
		m.put(1, "1");
		m.put(5, "5");
		m.put(3, "3");
		m.put(7, "7");
		m.put(2, "2");
		m.put(4, "4");
		m.put(6, "6");
		m.put(9, "9");
		m.put(8, "8");
		m.put(11, "11");
		m.put(15, "15");
		m.put(13, "13");
		m.put(17, "17");
		m.put(12, "12");
		m.put(14, "14");
		m.put(16, "16");
		m.put(19, "19");
		m.put(18, "18");
		m.put(55, "55");
		m.put(33, "33");
		m.put(77, "77");
		m.put(22, "22");
		m.put(44, "44");
		m.put(66, "66");
		m.put(99, "99");
		m.put(88, "88");
		System.out.println(m);
		Set<Entry<Integer,String>> set = m.entrySet();
		Iterator<Entry<Integer,String>> iter = set.iterator();
		while(iter.hasNext()){
			Entry<Integer,String> et = iter.next();
			System.out.println(et.getKey() + " | " + et.getValue());
		}
	}
	
	
	@Test
	public void test02(){
		//hashmap 键和值都可以为null
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
		
		//hashtable 键和值都不允许是Null
		Map ht = new Hashtable();
		ht.put("a", "a");
		ht.put("b", "b");
		ht.put("c", "c");
		//ht.put(null,"d");   //编译报错,hashtable的key和value都不能是null!!
		//ht.put("d", null);  //编译报错,hashtable的key和value都不能是null!!
		
	}
	
	@Test
	public void testTreeMapSort(){
		/**
		 * 1、TreeMap如不指定排序器，默认将按照key值进行升序排序
         *    如果指定了排序器，则按照指定的排序器进行排序。
		 * 2、具体的排序规则，开发人员可以在int compare()方法中进行指定。
		 */
		TreeMap<Student,String> tm  = new TreeMap<Student,String>(new Comparator<Student>(){  
            /* 
             * int compare(Object o1, Object o2) 返回一个基本类型的整型， 
             * 返回负数表示：o1 小于o2， 
             * 返回0 表示：o1和o2相等， 
             * 返回正数表示：o1大于o2。 
             */  
            public int compare(Student s1, Student s2) {
                //指定排序器按照降序排列  
                return s2.getAge().compareTo(s1.getAge());
            }     
        });
		
		tm.put(new Student("张三",3),"33");
		tm.put(new Student("李四",4),"44");
		tm.put(new Student("王五",5),"55");
		
		System.out.println(tm);  

	}
}
