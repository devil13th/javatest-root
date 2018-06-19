/** 
 * Class Description:########
 * Date : 2016年12月28日 上午10:41:41
 * Auth : wanglei 
*/  

package com.thd.itext.text;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class AddPositionPDFTableExample {
	public  static void main(String[] args) throws Exception{
		 //创建一个文档对象纸张大小为A4
        Document doc=new Document(PageSize.A4,50,50,50,50);
        //设置要输出到磁盘上的文件名称
        PdfWriter writer=PdfWriter.getInstance(doc,new FileOutputStream(new File("D://deleteme//aaabbb.pdf")));
        //设置作者信息
        doc.addAuthor("sxyx2008");
        //设置文档创建日期
        doc.addCreationDate();
        //设置标题
        doc.addTitle("iText测试");
        //设置值主题
        doc.addSubject("iText");


        //打开文档开始写内容
        doc.open();
        
        
        //Paragraph paragraph = new Paragraph("世界你好！",getChineseFont());
        //doc.add(paragraph);
        //创建一个1列的表格
        PdfPTable table=new PdfPTable(1);
        
       
        
        table.setTotalWidth(200);
        table.setLockedWidth(true);
        //设置编号单元格
    	PdfPCell cell11=new PdfPCell(new Phrase("浮动表格浮动表格浮\n动表格浮动表格浮动表123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890",getChineseFont()));
    	//单元格水平对齐方式
        cell11.setHorizontalAlignment(Element.ALIGN_LEFT);
        //单元格垂直对齐方式
        cell11.setVerticalAlignment(Element.ALIGN_BOTTOM);
        cell11.setMinimumHeight(100);
        table.addCell(cell11);

        PdfContentByte pcb = writer.getDirectContentUnder();
        table.writeSelectedRows(0, -1, 100, 500, pcb);
       // table.writeSelectedRows(0,-1, 0, -1, 100, 200, pcb);
        //将表格添加到新的文档
        //doc.add(table);
        
        
        
        
        
        
        doc.close();
        writer.close();
        System.out.println("finish");
    }
	
	 //pdf文档中文字符处理
    public static Font getChineseFont()
    {
        BaseFont baseFont=null;
        try {
        	String songBoldTtfPath = "E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext" + File.separator + "simsun-bold.ttf";
    		baseFont = BaseFont.createFont(songBoldTtfPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font chineseFont=new Font(baseFont,8,Font.NORMAL,Color.BLUE);
        return chineseFont;
    }


}
