package com.thd.base64;

import junit.framework.TestCase;

import org.junit.Test;


public class Base64ToolTester extends TestCase{
	@Test
	public void testencodeBase64File(){
		try{
			String str = Base64Tool.encodeBase64File("D://hs.xml");
			System.out.println(str);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testdecoderBase64File(){
		try{
			String str = Base64Tool.encodeBase64File("D://test.pdf");
			Base64Tool.decoderBase64File(str,"D://cccc.pdf");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testencodeStr(){
		try{
			String str = "我是中国人，这是中国的土地!@#$%^&*()";
			String estr = Base64Tool.encodeStr(str);
			System.out.println(estr);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testdecodeStr(){
		try{
			//String estr = "5oiR5piv5Lit5Zu95Lq677yM6L+Z5piv5Lit5Zu955qE5Zyf5ZywIUAjJCVeJiooKQ==";
			String estr = "5LiA5p2hNTUwMDBEV1Qg5pWj6LSn6Ii577yM6K+B5Lmm5pyJ5pWI5pyf5pivMjAxMi0wMi0xNeOAgueUseS6juiIqueoi+mcgOimgeS6jjIwMDgtMTAtMjAg5a6M5oiQ56ys5LqM5qyh5bm05qOA77yM5Zug5q2k56ys5LiJ5qyh5bm05qOA55qE5pyA5ZCO5pel5pyf5Li677yI77yJ44CC";
			String str = Base64Tool.decodeStr(estr);
			System.out.println(str);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
