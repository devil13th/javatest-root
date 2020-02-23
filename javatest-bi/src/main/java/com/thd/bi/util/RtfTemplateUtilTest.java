package com.thd.bi.util;

import com.thd.bi.dto.example.ModelBean;
import com.thd.bi.dto.example.SubList;
import com.thoughtworks.xstream.XStream;
import oracle.apps.xdo.template.FOProcessor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RtfTemplateUtilTest {

	public static void main(String[] args) {
		
		
		/**
		 * 在D盘建立deleteme目录，
		 * 将该类所在包下的font文件夹和testForm.rtf以及xdo.cfg拷贝到D:/deleteme目录下
		 * 目录结构如下
		 * D:/
		 * |-deleteme
		 *     |-testForm.rtf
		 *     |-font
		 *        |-ALBANWTS.ttf
		 *        |-SIMFANG.TTF
		 *        |-SIMSUN.TTC
		 *        |-....
		 * 
		 */
		
		//rtf模板路径
		String rtfTemplateFilePath="D://deleteme//testForm.rtf";
		//中间过程生成的xsl路径
		String xslFilePath="D://deleteme//xsldata.xsl";
		//xml数据路径
		String xmlFilePath="D://deleteme//xmlData.xml";
		//配置文件位置
		String cfgFilePath="D://deleteme//xdo.cfg";
		//输出最终文件位置
		String resultPdfFilePath = "D://deleteme//aaa.pdf";
		//输出文件种类
		byte outputFormat = 
		FOProcessor.FORMAT_PDF;
//		FOProcessor.FORMAT_EXCEL;
//		FOProcessor.FORMAT_HTML;
//		FOProcessor.FORMAT_RTF;
		//生成xdo.cfg文件(生成一次即可)
		RtfTemplateUtil.generateXdoCfg(cfgFilePath, "D://devil13th/github//javatest-bipublisher//src//com//thd//bipublisher//font//");
		
		
		// 生成xml文件
		ModelBean mb = new ModelBean();
		List<SubList> sl = new ArrayList<SubList>();
		for(int i = 0 , j = 200 ; i < j ; i++){
			SubList s = new SubList();
			s.setId(i);
			s.setName("姓名1" + i );
			s.setRemark("备注2" + i);
			sl.add(s);
		}
		mb.setFlag(0);
		mb.setFormName("测试FORM昇威管理有限公司");
		mb.setSubListArray(sl);
			
		XStream xstream = new XStream();
		//去掉生成xml标签的包名前缀
		xstream.aliasPackage("", "com.lenovo.dqm.bi");
		
		String hlStr = xstream.toXML(mb);
		String outStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
		outStr += hlStr;
		
		//写入到文件
		FileWriter fw = null;
		File xmlFile = new File(xmlFilePath);
		try {
			if (!xmlFile.exists()) {
				xmlFile.createNewFile();
			}
			fw = new FileWriter(xmlFile);
			//BufferedWriter out = new BufferedWriter(fw,"UTF8");
			OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(xmlFile),"UTF-8"); 
			BufferedWriter out=new BufferedWriter(write);   
			out.write(outStr, 0, outStr.length());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		RtfTemplateUtil rtfUtil = new RtfTemplateUtil(
				rtfTemplateFilePath,  
				xslFilePath,
				 xmlFilePath,  
				 cfgFilePath,  
				 resultPdfFilePath,outputFormat);
		
		rtfUtil.genarateReportPdf();
		System.out.println("success");
	}

}
