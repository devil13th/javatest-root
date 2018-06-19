/** 
 * Class Description:########
 * Date : 2016年12月28日 下午5:15:53
 * Auth : wanglei 
*/  

package com.thd.xstream;

import java.util.HashMap;
import java.util.Map;

public class MapToXml {

	public static void main(String[] args) {
		Map m = new HashMap();
		m.put("name","张三");
		m.put("age", "5");
		m.put("sex","男");
		String str = XMLTool.objectToStr(m);
		System.out.println(str);

	}

}
