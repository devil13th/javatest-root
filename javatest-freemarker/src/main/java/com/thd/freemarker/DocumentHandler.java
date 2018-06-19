package com.thd.freemarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class DocumentHandler {

	private Configuration configuration = null;

	public DocumentHandler() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
	}

	public void createDoc() {
		// 要填入模本的数据文件
		Map dataMap = new HashMap();
		getData(dataMap);
		// 设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载，
		// 这里我们的模板是放在com.havenliu.document.template包下面
		configuration.setClassForTemplateLoading(this.getClass(),"/com/thd/freemarker");
		Template t = null;
		try {
			//test.ftl为要装载的模板
			//t = configuration.getTemplate("test.ftl");
			t = configuration.getTemplate("2.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输出文档路径及名称
		File outFile = new File("D:/outFile.doc");
		Writer out = null;
		try {
			//out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
			out = new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"); 
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			t.process(dataMap, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 注意dataMap里存放的数据Key值要与模板中的参数相对应
	 * 
	 * @param dataMap
	 */
	private void getData(Map dataMap) {
		dataMap.put("a", "张三\t |aaab1");
		dataMap.put("b", "张三2");
		dataMap.put("c", "张三3");
		dataMap.put("d", "张三4");
		dataMap.put("e", "张三5");
	}
	
	public static void main(String[] args){
		DocumentHandler s = new DocumentHandler();
		s.createDoc();
		System.out.println("文件生成完成！");
	}
}
