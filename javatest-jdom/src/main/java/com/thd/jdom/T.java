package com.thd.jdom;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class T {
	public static void main(String args[]) throws Exception{
		System.out.println("Init");
		SAXBuilder builder = new SAXBuilder();
		URL url = new URL("http://127.0.0.1:8080/webgate/getPermissions.xml?roleId=8a8082ed33c9c97d0133c9dd06260000");
		Document doc = builder.build(url);
		//[element] map
		Element root = doc.getRootElement();
		
		//[list map] - entry
		List<Element> listType = root.getChildren("entry");
		
		Map<String,Map<String,String>> map = new HashMap<String,Map<String,String>>();
		
		for(int i = 0 , j = listType.size() ; i < j ; i++){
			//[element] map - entry
			Element el = listType.get(i);
			//[element] map - entry - string
			Element tit = (Element)el.getChildren("string").get(0);
			//[element] map - entry - map
			Element vMap = (Element)el.getChildren("map").get(0);
			//[list] map - entry - map - entry
			List<Element> vMapC = vMap.getChildren("entry");
			
			Map<String,String> vv = new HashMap<String,String>();
			for(int x = 0 , y = vMapC.size() ; x < y ; x++){
				//[element] map - entry - map - entry
				Element _el = vMapC.get(i);
				String k = ((Element)_el.getChildren("string").get(0)).getText();
				String v = ((Element)_el.getChildren("string").get(1)).getText();
				vv.put(k,v);
				System.out.println(tit.getText() + ":[" + k +"|"+ v + "]");
			}
			map.put(tit.getText(),vv);
		}
		
		
		System.out.println("finish");
		System.out.println(map.get("menuMap").get("pages/user/userManager"));
		
		
	}
}
