package com.thd.velocity;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

public class Test {

	public static void main(String[] args) {
		VelocityEngine ve = new VelocityEngine(); 
		ve.setProperty(Velocity.ENCODING_DEFAULT, "utf-8");
		ve.setProperty(Velocity.INPUT_ENCODING, "utf-8");
		ve.setProperty(Velocity.OUTPUT_ENCODING, "utf-8");
		ve.init(); 
		//相对路径
		Template t = ve.getTemplate("src/com/thd/velocity/template01.vm"); 
		VelocityContext context = new VelocityContext(); 
		context.put("name", "Liang");
		context.put("date", (new Date()).toString()); 
		
		List temp = new ArrayList(); 
		temp.add("元素一"); 
		temp.add("元素二"); 
		context.put("list", temp); 
		
		context.put("msg", "i'm msg");
		
		StringWriter writer = new StringWriter(); 
		
		User u = new User("张三","52");
		context.put("user",u);
		//转换输出 
		t.merge(context, writer); 
		System.out.println(writer.toString()); 

	} 

}
