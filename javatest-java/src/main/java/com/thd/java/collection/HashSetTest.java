package com.thd.java.collection;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;

import com.thd.java.bean.User;

public class HashSetTest extends TestCase {
	@Test
	public void test01(){
		Set<String> s = new HashSet<String>();
		
		s.add("张三");
		s.add("李四");
		s.add("王五");
		s.add("王五");
		
		for(String str : s){
			System.out.println(str);
		}
	}
	
	@Test
	public void test02(){
		Set<Integer> s = new HashSet<Integer>();
		s.add(3);
		s.add(1);
		s.add(2);
		s.add(2);
		s.add(1);
		s.add(new Integer(3));
		
		for(Integer str : s){
			System.out.println(str);
		}
	}
	
	@Test
	public void test03(){
		Set<User> s = new HashSet<User>();
		User u1 = new User("张三",1);
		User u2 = new User("李四",2);
		User u3 = new User("王五",3);
		User u4 = new User("王五",3);
		User u5 = u2;
		s.add(u1);
		s.add(u2);
		s.add(u3);
		s.add(u4);
		s.add(u5);
		for(User u : s){
			System.out.println(u.getName() + "|" + u.getAge());
		}
	}
}
