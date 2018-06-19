/** 
 * Class Description:########
 * Date : 2016年11月8日 上午8:59:59
 * Auth : wanglei 
*/  

package com.thd.itext;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;

public class PdfTemplateUtilTester extends TestCase {
	@Test
	public void test01() {
		
		try {
			String templatePath = "E://thdsvn//java_project//javatest-root//javatest-acrobat//src//test//java//com//thd//itext//CSE(CHN)2.5_template.pdf";
			Map map = new HashMap();
			map.put("formCode", "你好");
			map.put("formNo", "1111");
			map.put("jobno", "jobno");
			map.put("shipNameCn", "shipNameCn");
			map.put("shipNameEn", "shipNameEn");
			map.put("hullNo", "hullNo");
			map.put("shipPort", "shipPort");
			map.put("gross", "gross");
			map.put("load", "load");
			map.put("width", "width");
			map.put("sihpType", "sihpType");
			map.put("ccsno", "ccsno");
			map.put("imono", "imono");
			map.put("buildDate", "buildDate");
			String fontPath = "E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext" + File.separator + "simsun-bold.ttf";
			String targetFilePath = "D://deleteme//sec.pdf";
			PdfTemplateUtil.createPdfByPdfTemplate(templatePath, map, fontPath, targetFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
