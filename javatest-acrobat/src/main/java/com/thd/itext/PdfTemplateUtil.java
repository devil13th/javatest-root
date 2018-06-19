package com.thd.itext;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

public class PdfTemplateUtil {
	
	/**
	 * 根据模板生成PDF
	 * @param templatePath 模板位置
	 * @param valueMap 值
	 * @param fontPath 字体位置
	 * @param targetFilePath 生成文件的位置
	 * @return
	 * @throws Exception
	 */
	public static String createPdfByPdfTemplate(String templatePath,Map valueMap,String fontPath,String targetFilePath) throws Exception{
		/* pdf模板位置 */
		String templatePDF = templatePath;
		PdfReader reader = new PdfReader(templatePDF);
		
		//字体位置
		String songBoldTtfPath = fontPath;
		/*
		名称-文件的字体或其位置的名称
		编码-将被应用到这个字体的编码
		嵌入式-是否被嵌入到PDF中
		 */
		BaseFont songBold = BaseFont.createFont(songBoldTtfPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		
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
			 * 参数1：pdf文本域的名字
			 * 参数2：设置的属性名称
			 * textfont - sets the text font. The value for this entry is a BaseFont.
				textcolor - sets the text color. The value for this entry is a java.awt.Color.
				textsize - sets the text size. The value for this entry is a Float.
				bgcolor - sets the background color. The value for this entry is a java.awt.Color. If null removes the background.
				bordercolor - sets the border color. The value for this entry is a java.awt.Color. If null removes the border.
			 * 参数3:参数2属性对应的值
			 * 参数4：an array of int indexing into AcroField.Item.merged elements to process. Set to null to process all
			 * 一定要设置字体否则会报如下错
			 * ExceptionConverter: com.lowagie.text.DocumentException: Font 'STSongStd-Light' with 'UniGB-UCS2-H' is not recognized.
			 * 因为默认的是上面报错的字体，设置字体后就不会报错了
			 * 
			 * 设置字体一定要在设置值之前否则会报上面同样的错误!!
			 */
			acroForm.setFieldProperty(entry.getKey().toString(), "textfont", songBold, null);
			/**
			 * 遍历Map中的值 ，设置PDF中文本域的值
			 */
			acroForm.setField(entry.getKey().toString(), entry.getValue()!=null?entry.getValue().toString():"");
		}
		
		stamp.setFormFlattening(true);
		stamp.close();
		
		String outputFileName = targetFilePath;
		FileOutputStream out = null;
		try {
			String s = new String(ba.toByteArray());
			out = new FileOutputStream(new File(outputFileName));
			ba.writeTo(out);
			System.out.println("finish");
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		} finally {
			try {
				out.close();
				ba.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 合并PDF
	 * Method Description : ########
	 * @param files 需要合并的PDF文件列表
	 * @param outPath 合并后文件位置
	 * @param paginate 是否重新计算页数
	 */
	public static void concatPDFs(List<File> files, String outPath, boolean paginate) {
		Document document = new Document();
		OutputStream outputStream = null ;
        try {
        	outputStream = new FileOutputStream(outPath);

        	List<PdfReader> readers = new ArrayList<PdfReader>();
        	int totalPages = 0;
        	// Create Readers for the pdfs.
        	for(File f:files){
        		InputStream pdf = new FileInputStream(f);
        		PdfReader pdfReader = new PdfReader(pdf);
                readers.add(pdfReader);
                totalPages += pdfReader.getNumberOfPages();
        	}
        	PdfWriter writer = PdfWriter.getInstance(document, outputStream);

        	// Create a writer for the outputstream
            document.open();
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,
                    BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            PdfContentByte cb = writer.getDirectContent(); // Holds the PDF

            PdfImportedPage page;
            int currentPageNumber = 0;
            int pageOfCurrentReaderPDF = 0;
            Iterator<PdfReader> iteratorPDFReader = readers.iterator();

            // Loop through the PDF files and add to the output.
            while (iteratorPDFReader.hasNext()) {
                PdfReader pdfReader = iteratorPDFReader.next();
                // Create a new page in the target for each source page.
                while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {
                    document.newPage();
                    pageOfCurrentReaderPDF++;
                    currentPageNumber++;
                    page = writer.getImportedPage(pdfReader,
                            pageOfCurrentReaderPDF);
                    cb.addTemplate(page, 0, 0);

                    // Code for pagination.
                    if (paginate) {
                        cb.beginText();
                        cb.setFontAndSize(bf, 9);
                        cb.showTextAligned(PdfContentByte.ALIGN_CENTER, ""
                                + currentPageNumber + " of " + totalPages, 520,
                                5, 0);
                        cb.endText();
                    }
                }
                pageOfCurrentReaderPDF = 0;
            }
            outputStream.flush();
            document.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document.isOpen())
                document.close();
            try {
                if (outputStream != null)
                    outputStream.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}
