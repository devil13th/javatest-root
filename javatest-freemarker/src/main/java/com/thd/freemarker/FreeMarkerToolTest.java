package com.thd.freemarker;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;

public class FreeMarkerToolTest extends TestCase{
	@Test
	public void testtoWord() throws Exception{
		Map data = new HashMap();
		data.put("a", "张三\t |aaab1");
		data.put("b", "张三2");
		data.put("c", "张三3");
		data.put("d", "张三4");
		data.put("e", "张三5");
		URL u = FreeMarkerToolTest.class.getClass().getResource("/com/thd/freemarker");
		System.out.println(u.getPath());
		FreeMarkerTool.fillData(data, u.getPath(), "2.xml", "D://2.doc", "UTF-8");
		System.out.println("finish");
	}
	
	@Test
	public void testtoWord02() throws Exception{
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		//注意 如果是生成word 要把&替换成&amp;
		map.put("jobno", FreeMarkerTool.getStr("工作控&制号1"));
		map.put("productname", "产品名称");
		map.put("model", FreeMarkerTool.getStr(null));
		map.put("internation", "internation");
		map.put("demest", "demest");
		map.put("certainno", "certainno");
        map.put("shipyard", "shipyard");
        map.put("othersuse", "othersuse");
        map.put("orderno", "orderno");
        map.put("original", "original");
        map.put("toReturn", "toReturn");
        map.put("drawingsscores", "drawingsscores");
        map.put("technicalspecification", "technicalspecification");
        map.put("drawinglist","drawinglist");
        map.put("drawinglist","drawinglist");
        map.put("acompanyname", "acompanyname");
        map.put("applyerName", "applyerName");
        map.put("addr", "addr");
        map.put("city", "city");
        map.put("province", "province");
        map.put("country", "country");
        map.put("phone", "phone");
        map.put("fax", "fax");
        map.put("url", "url");
        map.put("generalEmail","generalEmail");
        map.put("name", "name");
        map.put("email", "email");
        map.put("postcode", "postcode");
       // map.put("builderFactoryName", project.getBuilder().getNameCn());
        map.put("builderFactoryName", "builderFactoryName");
        map.put("builderAddr", "builderAddr");
        map.put("builderCity", "builderCity");
        map.put("builderProvince", "builderProvince");
        map.put("builderCountry", "builderCountry");
        map.put("builderPhone", "builderPhone");
        map.put("builderFax", "builderFax");
        map.put("builderUrl", "builderUrl");
        map.put("builderGeneralEmail", "builderGeneralEmail");
        map.put("builderName", "builderName");
        map.put("builderEmail","builderEmail");
        map.put("builderPostcode","builderPostcode");
		URL u = FreeMarkerToolTest.class.getClass().getResource("/com/thd/freemarker");
		System.out.println(u.getPath());
		//FreeMarkerTool.fillData(map, "D://wow", "application.xml", "D://application.doc", "UTF-8");
		FreeMarkerTool.fillData(map, "D://wow/application.xml", "D://application.doc", "UTF-8");
		System.out.println("finish");
	}
	
	@Test
	public void testToText() throws Exception{
		Map data = new HashMap();
		data.put("no",223);
		data.put("str","hello word");
		data.put("condition", "1");
		
		List a = new ArrayList();
		a.add("a1");
		a.add("a2");
		a.add("a3");
		data.put("a",a);
		
		User user = new User("张三","男");
		data.put("user", user);
		
		data.put("b", true);
		
		data.put("_x", 9);
		data.put("longStr", "1234567890");
		
		Map m = new HashMap();
		m.put("a","ax");
		m.put("b", "bx");
		data.put("map",m );
		
		
		List userList = new ArrayList();
		userList.add(new User("张三1","男1"));
		userList.add(new User("张三2","男2"));
		userList.add(new User("张三3","男3"));
		userList.add(new User("张三4","男4"));
		data.put("userList",userList);
		
		
		//FreeMarkerTool.fillData(data, dir, templateName, targetPath, charset) 
		URL u = FreeMarkerToolTest.class.getClass().getResource("/com/thd/freemarker");
		System.out.println(u.getPath());
		FreeMarkerTool.fillData(data, u.getPath(), "template.ftl", "D://a.txt", "UTF-8");
		System.out.println("finish");
	}
	
}
