package com.thd.itext;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.lowagie.text.Cell;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class Example {
	
	public static String formatStrForPdf(Object str) {
		if (str!=null) {
			String s=str.toString();
			if (s == null || "".equals(s.trim())|| "null".equalsIgnoreCase(s.trim())) {
				return "---";
			} else {
				return s;
			}
		}
		return "---";
	}
	
	public static void main(String[] args) throws Exception{
		Map<String,String> valueMap = new HashMap<String,String>();
		
		//添加字体(用于中文显示) 拷贝windows下的字体即可
		String songBoldTtfPath = "E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext" + File.separator + "simsun-bold.ttf";
		BaseFont songBold = BaseFont.createFont(songBoldTtfPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		//设置pdf模板中的值(封装成Map了)
		valueMap.put("name", "十三妖");
		valueMap.put("birthday", "2014-01-01");
		valueMap.put("school", "北京清华大学");
		valueMap.put("education", "大学本科");
		valueMap.put("interest", "欧美重金属、音乐、吉他、篮球、游泳、旅游、看书、交友、等");
		valueMap.put("introdu", "上知天文,下知地理,中晓人和,明阴阳,懂八卦,晓奇门,知遁甲,运筹帷幄之中,决胜千里之外,自比管仲乐毅之贤,抱膝危坐,啸傲风月,未出茅庐先定三分天下.");
		
		
		
		/* pdf模板位置 */
		String templatePDF = "E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext//text.pdf";
		PdfReader reader = new PdfReader(templatePDF);
		
		/* 将要生成pdf文件的名称 */
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		PdfStamper stamp = new PdfStamper(reader, ba);
		
		
		/* 取出报表模板中的所有字段 */
		AcroFields acroForm = stamp.getAcroFields();
		
		Set set = valueMap.entrySet();
		java.util.Iterator it = valueMap.entrySet().iterator();
		while (it.hasNext()) {
			java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
			/**
			 * pdf文本域的名字
			 * 设置的属性名称
			 * 
			 */
			//acroForm.setFieldProperty("name", "textfont", songBold, null);
			acroForm.setFieldProperty(entry.getKey().toString(), "textfont", songBold, null);
			/**
			 * 遍历Map中的值 ，设置PDF中文本域的值
			 */
			acroForm.setField(entry.getKey().toString(), entry.getValue()!=null?entry.getValue().toString():"");
			//acroForm.setField(entry.getKey().toString(),formatStrForPdf(entry.getValue()));
		}
		
		
		/**
		 * 加入文字方法
		 */
		PdfContentByte over = stamp.getOverContent(1);
		over.beginText();
		over.setFontAndSize(songBold, 10);
		Color color = new Color(255,0,255); 
		over.setColorFill(color);
		over.setTextMatrix(200, 200);
		over.showTextAligned(Element.ALIGN_LEFT,"需要添加的文字 hello world 12345678901234567890",0,530,0);
		over.endText();
		
        
		/**
		 * 加入图片的方法
		 */
		Image gif = Image.getInstance("E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext//aa.jpg");
		gif.setDpi(100, 100);
		gif.setBorderWidth(100);
		Color c = new Color(255, 0,0); 
		gif.setBorderColor(c);
		//设置图片的宽和高
		gif.scaleAbsolute(60, 70); 
		//以PDF左下角为基准的 x坐标\y坐标
		gif.setAbsolutePosition(442, 695);
		//图片加载PDF第1页
		//PdfContentByte over = stamp.getOverContent(1);
		over.addImage(gif);
		stamp.setFormFlattening(true);
//		
		stamp.close();
		
		String outputFileName = "D://deleteme//aaabbb.pdf";
		FileOutputStream out = null;
		try {
			String s = new String(ba.toByteArray());
			out = new FileOutputStream(new File(outputFileName));
			ba.writeTo(out);
			System.out.println("finish");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				ba.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
