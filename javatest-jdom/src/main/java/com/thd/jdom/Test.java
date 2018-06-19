package com.thd.jdom;

import java.io.InputStream;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class Test {

	public static void main(String[] args) {
		try{
			InputStream is = Test.class.getResourceAsStream("test.xml");
			SAXBuilder builder = new SAXBuilder();   
			Document doc = builder.build(is);
			Element root = doc.getRootElement();   
            List<Element> c = root.getChildren("rs");   
            for(Element rs : c){   
                Attribute attr = rs.getAttribute("id");   
                Element tit = rs.getChild("title");   
                System.out.println(tit.getText());   
                System.out.println(attr.getValue());   
            }   
            System.out.println("success");   

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
