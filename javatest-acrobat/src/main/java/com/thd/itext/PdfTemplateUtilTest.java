package com.thd.itext;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.lowagie.text.pdf.BaseFont;

public class PdfTemplateUtilTest{

	public static void main(String[] args)  throws Exception{
		//字体文件
		String fontPath = "E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext" + File.separator + "simsun-bold.ttf";
		
		// pdf模板位置 
		String templatePath = "E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext//text.pdf";
		
		//设置值
		Map<String,String> valueMap = new HashMap<String,String>();
		valueMap.put("name", "十三妖");
		valueMap.put("birthday", "2014-01-01");
		valueMap.put("school", "北京清华大学");
		valueMap.put("education", "大学本科");
		valueMap.put("interest", "欧美重金属、音乐、吉他、篮球、游泳、旅游、看书、交友、等");
		valueMap.put("introdu", "上知天文,下知地理,中晓人和,明阴阳,懂八卦,晓奇门,知遁甲,运筹帷幄之中,决胜千里之外,自比管仲乐毅之贤,抱膝危坐,啸傲风月,未出茅庐先定三分天下.");
		
		//输出文件位置
		String targetFilePath = "D://deleteme//aaaa.pdf";
		
		PdfTemplateUtil.createPdfByPdfTemplate(templatePath, valueMap, fontPath, targetFilePath);
		System.out.println("success");
	}

}
