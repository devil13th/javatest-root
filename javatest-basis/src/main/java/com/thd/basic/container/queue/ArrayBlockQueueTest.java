package com.thd.basic.container.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import junit.framework.TestCase;

import org.junit.Test;


public class ArrayBlockQueueTest extends TestCase {
	@Test
	public void testput() throws Exception{
		BlockingQueue<String> q = new ArrayBlockingQueue<String>(5);
		q.put("1");
		System.out.println("put 1");
		q.put("2");
		System.out.println("put 2");
		q.put("3");
		System.out.println("put 3");
		q.put("4");
		System.out.println("put 4");
		q.put("5");
		System.out.println("put 5");
		//放入超出容量的元素会阻塞,下面的代码不执行一直处于等待
		q.put("6");
		System.out.println("put 6");
		System.out.println("finish");
	}
	@Test
	public void testtake() throws Exception{
		BlockingQueue<String> q = new ArrayBlockingQueue<String>(5);
		q.put("1");
		q.put("2");
		q.put("3");
		q.put("4");
		q.put("5");
		//放入超出容量的元素会阻塞
		//q.put("6");
		String str = q.take();
		System.out.println(str);
		str = q.take();
		System.out.println(str);
		str = q.take();
		System.out.println(str);
		str = q.take();
		System.out.println(str);
		str = q.take();
		System.out.println(str);
		
		//获取不到元素会阻塞
		str = q.take();
		System.out.println(str);
		System.out.println("finish");
	}
	
	
	
	@Test
	public void testoffer() throws Exception{
		BlockingQueue<String> q = new ArrayBlockingQueue<String>(5);
		boolean s = false;
		s = q.offer("1");
		System.out.println("put 1 " + s);
		s = q.offer("2");
		System.out.println("put 2 " + s);
		s = q.offer("3");
		System.out.println("put 3 " + s);
		s = q.offer("4");
		System.out.println("put 4 " + s);
		s = q.offer("5");
		System.out.println("put 5 " + s);
		//放入超出容量的元素不会阻塞,返回false
		s = q.offer("6");
		System.out.println("put 6 " + s);
		System.out.println(q.size());
	}
	
	@Test
	public void testpoll() throws Exception{
		BlockingQueue<String> q = new ArrayBlockingQueue<String>(5);
		q.put("1");
		q.put("2");
		q.put("3");
		q.put("4");
		q.put("5");
		String str = q.poll();
		System.out.println(str);
		str = q.poll();
		System.out.println(str);
		str = q.poll();
		System.out.println(str);
		str = q.poll();
		System.out.println(str);
		str = q.poll();
		System.out.println(str);
		
		//获取超额的元素不会阻塞,直接返回空
		str = q.poll();
		System.out.println(str);
		System.out.println("finish");
	}
	
}
