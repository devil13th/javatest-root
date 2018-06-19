/** 
 * Class Description:########
 * Date : 2016年12月28日 上午10:41:41
 * Auth : wanglei 
 */

package com.thd.itext.text;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfGState;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class AddWaterMark {
	public static void main(String[] args) throws Exception {
		// 创建一个文档对象纸张大小为A4
		Document doc = new Document(PageSize.A4, 50, 50, 50, 50);

		PdfReader reader = new PdfReader("D://deleteme//sec.pdf");
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		PdfStamper stamp = new PdfStamper(reader, ba);
		addWatermark(stamp,"档  案");
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
	private static void addWatermark(PdfStamper pdfStamper, String waterMarkName) {
		PdfContentByte content = null;
		BaseFont base = null;
		Rectangle pageRect = null;
		PdfGState gs = new PdfGState();
		try { // 设置字体
			
			
			String songBoldTtfPath = "E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext" + File.separator + "simsun-bold.ttf";
    		File f = new File(songBoldTtfPath);
    		System.out.println(f);
    		base = BaseFont.createFont(songBoldTtfPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        	
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		try {
			if (base == null || pdfStamper == null) {
				return;
			}
			// 设置透明度为0.2
			gs.setFillOpacity(0.2f);
			gs.setStrokeOpacity(0.2f);
			int toPage = pdfStamper.getReader().getNumberOfPages();
			for (int i = 1; i <= toPage; i++) {
				pageRect = pdfStamper.getReader().getPageSizeWithRotation(i);
				pageRect.setBackgroundColor(Color.RED);
				// 计算水印X,Y坐标
				float x = pageRect.getWidth() / 2;
				float y = pageRect.getHeight() / 2;
				// 获得PDF最顶层
				content = pdfStamper.getOverContent(i);
				content.saveState();
				// set Transparency
				content.setGState(gs);
				content.beginText();
				content.setColorFill(Color.BLACK);
				content.setFontAndSize(base,120);
				// 水印文字成45度角倾斜
				content.showTextAligned(Element.ALIGN_CENTER, waterMarkName, x,
						y, 45);
				content.endText();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			content = null;
			base = null;
			pageRect = null;
		}
	}

}
