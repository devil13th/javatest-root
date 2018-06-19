package com.thd.hibernate.base;

import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

public class UsrServiceImplTest extends TestCase {
	private UsrService us = new UsrServiceImpl();
	
	
	public void testsave(){
		Test01 u = new Test01();
		u.setUsr("张三" + Math.random());
		u.setPwd("123456");
		u.setNickname("昵称" + Math.random());
		us.save(u);
	}
	
	public void testqueryAllUsr(){
		List<Test01> l = us.queryAllUsr(1,3);
		Test01 u = null;
		for(Iterator<Test01> iter = l.iterator() ; iter.hasNext() ; ){
			u = iter.next();
			System.out.println(u.getUsr() + "|" + u.getPwd() + "|" + u.getNickname());
			
		}
	}
	
	public void testqueryUsrByNickName(){
		List<Test01> l = us.queryUsrByNickName("w");
		Test01 u = null;
		for(Iterator<Test01> iter = l.iterator() ; iter.hasNext() ; ){
			u = iter.next();
			System.out.println(u.getUsr() + "|" + u.getPwd() + "|" + u.getNickname());
			
		}
		
	}
}
