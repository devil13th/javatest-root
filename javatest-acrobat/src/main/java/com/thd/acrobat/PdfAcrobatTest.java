package com.thd.acrobat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.junit.Test;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class PdfAcrobatTest {
	@Test
	public void test01() throws Exception{
		
		String TemplatePDF = "E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//acrobat//test.pdf";//设置模板路径
		FileOutputStream fos = new FileOutputStream("d:/test.pdf");//需要生成PDF
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//用于存储每页生成PDF流
		//字体
		String songBoldTtfPath = "E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext" + File.separator + "simsun-bold.ttf";
		BaseFont songBold = BaseFont.createFont(songBoldTtfPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		
		PdfReader reader = new PdfReader(TemplatePDF);
		PdfStamper stamp = new PdfStamper(reader, baos);
		AcroFields form = stamp.getAcroFields();
		//设置字体一定要在设置值之前否则会报错
		form.setFieldProperty("name", "textfont", songBold, null);
		form.setField("name", "十三妖");//插入的数据都为字符类型
		form.setFieldProperty("sex", "textfont", songBold, null);
		form.setField("sex", "男");	
		form.setFieldProperty("age", "textfont", songBold, null);
		form.setField("age", "30");	
		form.setFieldProperty("group", "textfont", songBold, null);
		form.setField("group", "group x");
		form.setFieldProperty("group[0]", "textfont", songBold, null);
		form.setField("group[0]", "group A");
		form.setFieldProperty("group[1]", "textfont", songBold, null);
		form.setField("group[1]", "group B");
		form.setFieldProperty("group[2]", "textfont", songBold, null);
		form.setField("group[2]", "group C");
		form.setFieldProperty("group[3]", "textfont", songBold, null);
		form.setField("group[3]", "group D");
		form.setFieldProperty("group[4]", "textfont", songBold, null);
		form.setField("group[4]", "group E");
		
		
		
		stamp.setFormFlattening(true); // 千万不漏了这句啊, */
		stamp.close();
		
		Document doc = new Document();
		PdfCopy pdfCopy = new PdfCopy(doc, fos);
		doc.open();
		PdfImportedPage impPage = null;
		/**取出之前保存的每页内容*/
		impPage = pdfCopy.getImportedPage(new PdfReader(baos.toByteArray()), 1);
		pdfCopy.addPage(impPage);
		doc.close();//当文件拷贝  记得关闭doc
		System.out.println("finish");
	}
}
