package com.thd.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class AppendTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			//InputStream is = T.class.getResourceAsStream("test.xml");
			File file = new File(AppendTest.class.getResource("test.xml").getPath());
			System.out.println(file.getPath());
			SAXReader saxReader=new SAXReader();
			Document document=saxReader.read(file);
			Element orders=document.getRootElement();//根节点
			Element rs = orders.addElement("rs");//创建节点
			rs.addAttribute("id", "c");
			
			Element title = rs.addElement("title");//创建节点
			title.setText("new title 标题");//设置节点内容
			
			Writer writer = new FileWriter(file);
			OutputFormat format= OutputFormat.createPrettyPrint();//格式化
			format.setEncoding("utf-8");
			
			//XMLWriter xmlWriter = new XMLWriter(writer,format);
			
			//用FileOutputStream可以解决中文问题
			XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(file),format);

			xmlWriter.write(document);
			xmlWriter.close();
			System.out.println("success");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
