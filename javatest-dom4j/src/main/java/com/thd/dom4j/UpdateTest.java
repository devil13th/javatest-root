package com.thd.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class UpdateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			//InputStream is = T.class.getResourceAsStream("test.xml");
			File file = new File(UpdateTest.class.getResource("test.xml").getPath());
			System.out.println(file.getPath());
			SAXReader saxReader=new SAXReader();
			Document document=saxReader.read(file);
			Element orders=document.getRootElement();//根节点
			
			Element rs = orders.element("rs").element("title");
			System.out.println(rs.getText());
			rs.setText("xxx 修改");
			
			List<Element> l = orders.elements("title");
			if(l!=null && !l.isEmpty()){
				for(Element e : l){
					e.setText("dddd");
				}
			}
			
			Writer writer = new FileWriter(file);
			OutputFormat format= OutputFormat.createPrettyPrint();//格式化
			format.setEncoding("utf-8");
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
