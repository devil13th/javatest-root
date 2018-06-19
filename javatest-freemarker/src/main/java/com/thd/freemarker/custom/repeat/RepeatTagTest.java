package com.thd.freemarker.custom.repeat;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.thd.freemarker.FreeMarkerTool;
import com.thd.freemarker.custom.MyTagOut;

public class RepeatTagTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Map data = new HashMap();
		data.put("repeat", new RepeatDirective());  
		RepeatBean rb = new RepeatBean();
		rb.setName("aaa");
		rb.setAge(5);
		data.put("bean", rb);
		URL u = RepeatTagTest.class.getClass().getResource("/com/thd/freemarker/custom/repeat");
		System.out.println(u.getPath());
		FreeMarkerTool.fillData(data, u.getPath(), "repeat.ftl", "D://repeat.txt", "UTF-8");
		System.out.println("finish");
	}

}
