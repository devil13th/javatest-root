package com.thd.acrobat;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
public class TestPdfTemplate {	
	public static void main(String[] args) {
		try {
			int count = 8;// 总记录数
			int pageCount = 4;// 每页记录数
			int index = 1; // 表格序号
			int page = 0;// 总共页数
			/** 主要控制总共的页数*/
			if (count >= pageCount && count % pageCount == 0) {
				page = count / pageCount;
			} else {
				page = count / pageCount + 1;
			}
			String TemplatePDF = "E://thdsvn//java_project//JAVA_TEST//src//com//thd//acrobat//PdfTemplate.pdf";//设置模板路径
			FileOutputStream fos = new FileOutputStream("d:/test.pdf");//需要生成PDF
			
			ByteArrayOutputStream baos[] = new ByteArrayOutputStream[page];//用于存储每页生成PDF流
			/** 向PDF模板中插入数据 */
			for (int item = 0; item < page; item++) {
				baos[item] = new ByteArrayOutputStream();
				PdfReader reader = new PdfReader(TemplatePDF);
				PdfStamper stamp = new PdfStamper(reader, baos[item]);
				AcroFields form = stamp.getAcroFields();
				form.setField("DepartmnetNmae", "蓝飞");//插入的数据都为字符类型
				form.setField("qq", "252462807");				
				form.setField("pageNumber", "第" + (item + 1) + "页,共" + page
						+ "页");
				if (count % pageCount != 0 && item == page - 1) {
					System.out.println("====pageCount+" + pageCount + "=====");
					pageCount = count % pageCount;
				}
				/**因为PDF中的表格其实是众多的文本域组成,就是一个组数,所以把它循环出来就可以了*/
				for (int j = 0; j < pageCount; j++) {
					form.setField("ProjectTask[" + j + "]", index + "");
					form.setField("星期一[" + j + "]", "星期一[" + index + "]");
					form.setField("星期二[" + j + "]", "星期二[" + index + "]");
					form.setField("星期三[" + j + "]", "星期三[" + index + "]");
					form.setField("星期四[" + j + "]", "星期四[" + index + "]");
					form.setField("星期五[" + j + "]", "星期五[" + index + "]");
					form.setField("星期六[" + j + "]", "星期六[" + index + "]");
					form.setField("星期日[" + j + "]", "星期日[" + index + "]");
					form.setField("意见[" + j + "]", "同意[" + j + "]");
					index++;
				}
				stamp.setFormFlattening(true); // 千万不漏了这句啊, */
				stamp.close();
			}
			Document doc = new Document();
			PdfCopy pdfCopy = new PdfCopy(doc, fos);
			doc.open();
			PdfImportedPage impPage = null;
			/**取出之前保存的每页内容*/
			for (int i = 0; i < page; i++) {
				impPage = pdfCopy.getImportedPage(new PdfReader(baos[i]
						.toByteArray()), 1);
				pdfCopy.addPage(impPage);
			}
			doc.close();//当文件拷贝  记得关闭doc
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}
}
