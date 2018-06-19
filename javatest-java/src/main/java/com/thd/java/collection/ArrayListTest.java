package com.thd.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.thd.java.bean.User;

/**
1.动态的增加和减少元素
2.灵活的设置数组的大小
3.随机读取能力强 List.get(Integer i) 可以随意调用
*/
public class ArrayListTest extends TestCase{
	@Test
	public void test01(){
		
		List<User> l = new ArrayList<User>();
		for(int i = 0 , j = 100 ; i < j ; i++){
			l.add(new User("name_" + i , i));
		}
		
		
	}
	
	
}
