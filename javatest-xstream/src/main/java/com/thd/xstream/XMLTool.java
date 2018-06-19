package com.thd.xstream;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.XStream;

public class XMLTool {
	/**
	 * 对象转xml字符串
	 * @param obj
	 * @return
	 */
	public static String objectToStr(Object obj){
		XStream m = new XStream();
		m.aliasPackage("", "com.thd.xstream.User");
		String xmlStr = m.toXML(obj);
		return xmlStr;
	}
	
	/**
	 * xml文件转对象
	 * @param xml
	 * @return
	 * @throws Exception
	 */
	public static Object xmlToObject(File xml) throws Exception{
		XStream m = new XStream();
		Object obj = m.fromXML(new FileReader(xml));
		return obj;
	}
	
	/**
	 * xml输入流转对象
	 * @param is
	 * @return
	 * @throws Exception
	 */
	public static Object xmlToObject(InputStream is) throws Exception{
		XStream m = new XStream();
		Object obj = m.fromXML(is);
		return obj;
	}
	
	/**
	 * xml字符串转对象
	 * @param xml xml字符串
	 * @return
	 * @throws Exception
	 */
	public static Object xmlStrToObject(String xml) throws Exception{
		InputStream in =new ByteArrayInputStream(xml.getBytes());
		return XMLTool.xmlToObject(in);
	}
	
	
	public static void main(String[] args) throws Exception{
		User u = new User();
		u.setAge(5);
		u.setMes("hello world <> \" !");
		u.setName("devil13th");
		u.setSex("male");
		IdCard ic = new IdCard();
		ic.setNo("110102....");
		u.setCard(ic);
		System.out.println(XMLTool.objectToStr(u));
		
		System.out.println("==========================");
		
		InputStream is = XMLTool.class.getResourceAsStream("xx.xml");
		User u2 = (User)XMLTool.xmlToObject(is);
		System.out.println(u2.getCard().getNo());
		System.out.println("==========================");
		
		User u3 = (User)XMLTool.xmlToObject(new File(XMLTool.class.getResource("xx.xml").getPath()));
		System.out.println(u3.getMes());
		
		
		
		Map m = new HashMap();
		m.put("a1","1");
		m.put("a2","2");
		m.put("a3","3");
		String s = XMLTool.objectToStr(m);
		System.out.println(s);
	}
}
