package com.thd.basic.container;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import junit.framework.TestCase;

import org.junit.Test;

public class ListTest extends TestCase {
	@Test
	public void testStack01(){
		
		//栈结构    后进先出   压栈  出栈
		Stack l = new Stack();
		l.push(1);
		l.push(2);
		l.push(3);
		l.push(4);
		l.push(5);
		
		System.out.println(l.pop());
		System.out.println(l.pop());
		System.out.println(l.pop());
		System.out.println(l.pop());
		System.out.println(l.pop());
		
	}
	@Test
	public void testQueue01(){
		//队列  先进先出 排队
		Queue q = new LinkedList();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.add(5);
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q.poll());
		
	}
	
	
	@Test
	public void testSort(){
		//List 是按照add的顺序进行排列的, 而set是按照自然排序进行排序的
		List l = new ArrayList();
		l.add(1);
		l.add(4);
		l.add(3);
		l.add(5);
		System.out.println(l);
		
		Set s = new HashSet();
		s.add(1);
		s.add(4);
		s.add(3);
		s.add(5);
		System.out.println(s);
	}
}
