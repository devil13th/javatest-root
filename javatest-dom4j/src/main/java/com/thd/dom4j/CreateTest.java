package com.thd.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class CreateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			Document document = DocumentHelper.createDocument();
			//document.setRootElement(document.addElement("root"));
			Element root = document.addElement("root");
			root.addAttribute("name", "SS");
			root.addAttribute("key", "SS_branch");
			root.addAttribute("xmlns", "http://jbpm.org/4.4/jpdl");
			for(int i = 0 , j = 5 ; i < j ; i++){
				Element rs =root.addElement("rs");
				rs.addAttribute("candidate-users", "#{auditUsers}");
				Element title = rs.addElement("title");
				title.addAttribute("id", "t_" + i);
				title.setText("title_" + i);
			}
			File file = new File(CreateTest.class.getResource("").getPath() + "tt.xml");
			Writer writer = new FileWriter(file);
			OutputFormat format= OutputFormat.createPrettyPrint();//格式化
			format.setEncoding("utf-8");
			//用FileOutputStream可以解决中文问题
			XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(file),format);

			xmlWriter.write(document);
			xmlWriter.close();
			System.out.println("success");
			
			System.out.println(CreateTest.class.getResource("").getPath());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
