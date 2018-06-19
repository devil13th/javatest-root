package com.thd.lucene;

import java.io.FileInputStream;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;

public class ReadContent {
	public static String getContent(String path) throws Exception{
		System.out.println(path.substring(path.length()-3));
		return null;
	}
	
	
	public static String readTxtFile(String path, int bufferLen, String code)
			throws Exception {
		StringBuffer result = new StringBuffer();
		FileInputStream fis = new FileInputStream(path);
		try {

			String line = "";
			byte[] buffer = new byte[1024 * bufferLen];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				line = new String(buffer, 0, len, code);
				result.append(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			fis.close();
		}
		return result.toString();
	}
	

	public static String readWorld(String path) throws Exception{
		StringBuffer content = new StringBuffer("");// 文档内容
		try {
			HWPFDocument doc = new HWPFDocument(new FileInputStream(path));
			Range range = doc.getRange();
			int paragraphCount = range.numParagraphs();// 段落
			for (int i = 0; i < paragraphCount; i++) {// 遍历段落读取数据
				Paragraph pp = range.getParagraph(i);
				content.append(pp.text());
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return content.toString().trim();

	}

	public static String readPDF(String path) throws Exception{
		try{
			StringBuffer content = new StringBuffer("");// 文档内容
			FileInputStream fis = new FileInputStream(path);
			PDFParser p = new PDFParser(fis);
			p.parse();
			PDFTextStripper ts = new PDFTextStripper();
			content.append(ts.getText(p.getPDDocument()));
			fis.close();
			return content.toString().trim();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	public static void main(String[] args) throws Exception {
		//System.out.println();
		//String str;
		//str = ReadContent.readTxtFile("D://lucene//files//0028.html", 8, "utf-8");
		//str = ReadContent.readWorld("D://FusionCharts_Free.doc");
		//str = ReadContent.readWorld("D://FusionCharts_Free.doc");
		//str = ReadContent.readPDF("D://JEECMS.pdf");
		//System.out.println(str);
		
		
		getContent("D://JEECMS.pdf");
		
		
	}
}
