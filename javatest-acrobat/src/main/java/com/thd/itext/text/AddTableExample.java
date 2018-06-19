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

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class AddTableExample {
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

        //构建页脚
        HeaderFooter footer=new HeaderFooter(new Phrase(), true);
        //设置页脚是否有边框
        //0表示无
        //1上边框
        //2下边框
        //3上下边框都有 默认都有
        //设置页脚是否有边框
        //footer.setBorder(0);
        footer.setBorder(1);
        //footer.setBorder(2);
        //footer.setBorder(3);
        //设置页脚的对齐方式
        footer.setAlignment(Element.ALIGN_LEFT);
        //将页脚添加到文档中
        doc.setFooter(footer);

        //打开文档开始写内容
        doc.open();
        //Paragraph par1=new Paragraph("Hello,Welcome You");
        //Paragraph par2=new Paragraph("你好，中文测试",ChineseFont());
        /**//*par1.setAlignment(Element.ALIGN_CENTER);
        doc.add(par1);*/
        //par2.setAlignment(Element.ALIGN_CENTER);
        //doc.add(par2);

        //构建一段落
        Paragraph par3=new Paragraph("客户信息表",ChineseFont());
        //设置局中对齐
        par3.setAlignment(Element.ALIGN_CENTER);
        //添加到文档
        doc.add(par3);

        //创建一个四列的表格
        Table table=new Table(4);
        //设置边框
        table.setBorder(1);

        //创建表头

        Cell cell1=new Cell(new Phrase("No.",ChineseFont()));
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setVerticalAlignment(Element.ALIGN_CENTER);
        cell1.setHeader(true);
        cell1.setBackgroundColor(Color.RED);

        Cell cell2=new Cell(new Phrase("Name.",ChineseFont()));
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setVerticalAlignment(Element.ALIGN_CENTER);
        cell2.setHeader(true);
        cell2.setBackgroundColor(Color.RED);

        Cell cell3=new Cell(new Phrase("Sex.",ChineseFont()));
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setVerticalAlignment(Element.ALIGN_CENTER);
        cell3.setHeader(true);
        cell3.setBackgroundColor(Color.RED);

        Cell cell4=new Cell(new Phrase("备注",ChineseFont()));
        cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell4.setVerticalAlignment(Element.ALIGN_CENTER);
        cell4.setHeader(true);
        cell4.setBackgroundColor(Color.RED);

        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        //添加此代码后每页都会显示表头
        table.endHeaders();
        
        //循环向表格中添加100条记录 100行4列的表格

        //以下代码的作用是创建100行数据,其中每行有四列,列依次为 编号 姓名 性别 备注
        for (int i = 1; i <=5; i++) {

            //设置编号单元格
            Cell cell11=new Cell(new Phrase(i+"",ChineseFont()));
            //设置姓名单元格
            Cell cell22=new Cell(new Phrase("世界你好2",ChineseFont()));
            //设置性别单元格
            Cell cell33=new Cell(new Phrase("世界你好3世界你好3世界你好3世界你好3世界你好3世界你好3世界你好3",ChineseFont()));
            //设置备注单元格
            Cell cell44=new Cell(new Phrase("世界你好4",ChineseFont()));
            
            //单元格水平对齐方式
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            //单元格垂直对齐方式
            cell11.setVerticalAlignment(Element.ALIGN_CENTER);
            
            
            cell22.setHorizontalAlignment(Element.ALIGN_RIGHT);
            cell22.setVerticalAlignment(Element.ALIGN_BOTTOM);

            cell33.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell33.setVerticalAlignment(Element.ALIGN_MIDDLE);

            cell44.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell44.setVerticalAlignment(Element.ALIGN_TOP);

            table.addCell(cell11);
            table.addCell(cell22);
            table.addCell(cell33);
            table.addCell(cell44);

        }

        //将表格添加到新的文档
        doc.add(table);
        
        
        
        
        
        
        
        
        
        
        Table table1 = new Table(3);
        table1.setBorderWidth(1);
        table1.setBorderColor(new Color(0, 0, 255));
        table1.setPadding(5);
        table1.setSpacing(5);
        Cell cell = new Cell("header");
        cell.setHeader(true);
        cell.setColspan(3);
        table1.addCell(cell);
        table1.endHeaders();
        cell = new Cell("example cell with colspan 1 and rowspan 2");
        cell.setRowspan(2);
        cell.setBorderColor(new Color(255, 0, 0));
        table1.addCell(cell);
        table1.addCell("1.1");
        table1.addCell("2.1");
        table1.addCell("1.2");
        table1.addCell("2.2");
        table1.addCell("cell test1");
        cell = new Cell("big cell");
        cell.setRowspan(2);
        cell.setColspan(2);
        table1.addCell(cell);
        table1.addCell("cell test2");
        doc.add(table1);
        
        //创建新的一页
        //doc.newPage();
        //添加图片
        //Image image=Image.getInstance("D://Program Files//myeclipseworkspace//6.5//iText//src//5.jpg");
        //添加到文档
        //doc.add(image);
        //设置对象方式
        //image.setAlignment(Element.ALIGN_CENTER);
        
        
        
        doc.close();
        writer.close();
        System.out.println("finish");
    }
	
	 //pdf文档中文字符处理
    public static Font ChineseFont()
    {
        BaseFont baseFont=null;
        try {
        	String songBoldTtfPath = "E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext" + File.separator + "simsun-bold.ttf";
    		File f = new File(songBoldTtfPath);
    		System.out.println(f);
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
