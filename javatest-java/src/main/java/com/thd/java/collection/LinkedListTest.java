package com.thd.java.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.thd.java.bean.User;

public class LinkedListTest extends TestCase {
	@Test
	public void test01(){
		
		List<User> l = new LinkedList<User>();
		for(int i = 0 , j = 100000 ; i < j ; i++){
			l.add(new User("name_" + i , i));
		}
		
		long start = System.currentTimeMillis();
		System.out.println(l.get(99999).getName() + "|" + l.get(99999).getAge());
		long end = System.currentTimeMillis();
		System.out.println("开始时间：" + start);
		System.out.println("结束时间：" + end);
		System.out.println("所用时间："  + (end - start));
	}
}
