package com.thd.freemarker.custom;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.thd.freemarker.FreeMarkerTool;

public class TagOutTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Map data = new HashMap();
		data.put("out", new MyTagOut());  
		URL u = TagOutTest.class.getClass().getResource("/com/thd/freemarker/custom");
		System.out.println(u.getPath());
		FreeMarkerTool.fillData(data, u.getPath(), "out.ftl", "D://22222.txt", "UTF-8");
		System.out.println("finish");

	}

}
