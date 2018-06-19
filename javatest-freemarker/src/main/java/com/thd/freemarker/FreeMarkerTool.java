package com.thd.freemarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerTool {
	
	/**
	 * 
	 * @param data 填充的数据
	 * @param dir 模板目录
	 * @param templateName 模板名称
	 * @param targetPath 生成位置
	 * @param charset 字符集
	 * @throws Exception
	 */
	public static void fillData(Map<String,Object> data,String dir,String templateName,String targetPath,String charset) throws Exception{
		//初使化FreeMarker配置
		Configuration  configuration = new Configuration();
		//设置要解析的模板所在的目录，并加载模板文件
		configuration.setDirectoryForTemplateLoading(new File(dir));
		//设置编码格式
		configuration.setDefaultEncoding(charset);
		Template t = null;
		
		
		// 获取模板,并设置编码方式，这个编码必须要与页面中的编码格式一致  
		// 否则会出现乱码 

		t = configuration.getTemplate(templateName,charset);
		
		if(targetPath == null){
			throw new Exception(" target path err !");
		}
		
		File outFile = new File(targetPath);
		Writer out = null;
		try {
			if(charset == null){
				out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
			}else{
				out = new OutputStreamWriter(new FileOutputStream(outFile), charset); 
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			t.process(data, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param data 数据
	 * @param templatePath 模板位置
	 * @param targetPath 生成位置
	 * @param charset 字符集
	 * @throws Exception
	 */
	public static void fillData(Map<String,Object> data,String templatePath,String targetPath,String charset) throws Exception{
		File template = new File(templatePath);
		//模板所在目录路径
		String dir = template.getParent();
		//模板名称
		String templateName = template.getName();
		FreeMarkerTool.fillData(data, dir, templateName, targetPath, charset);
	}
	
	/**
	 * 将字符串中的"&"替换为&amp; 用于生成word
	 * @param s 字符串
	 * @return 将&改为&amp;后的字符串
	 */
	public static String getStr(String s){
		String str = (s == null ? "" : s);
		if(str != null && !str.trim().equals("")){
			String r = str.replace("&","&amp;");
			return r;
		}
		return str;
	}
	
}
