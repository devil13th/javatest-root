/** 
 * Class Description:########
 * Date : 2016年12月30日 下午2:16:53
 * Auth : wanglei 
*/  

package com.thd.itext;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import junit.framework.TestCase;

import org.junit.Test;

import com.lowagie.text.Anchor;
import com.lowagie.text.Chapter;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Section;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

public class ItextTest extends TestCase {
	public String outputFile = "D://deleteme//aaabbb.pdf";
	
	public Document document;
	
	
	@Test
	//PDF文档生成的5步
	public void test01createPdf() throws Exception{
		OutputStream out = new FileOutputStream(new File(outputFile));
		 // 1-创建文本对象 Document   
		/**
		 *  Constructs a new Document -object.
		 *public Document(Rectangle pageSize, float marginLeft,float marginRight, float marginTop,float marginBottom)
		 *Parameters:
		 *	pageSize - the pageSize
		 *	marginLeft - the margin on the left
		 *	marginRight - the margin on the right
		 *	marginTop - the margin on the top
		 *	marginBottom - the margin on the bottom
		 */
        document = new Document(PageSize.A4, 50, 50, 50, 50);  
        // 2-初始化 pdf输出对象 PdfWriter  
        PdfWriter.getInstance(document,out);  
        // 3-打开 Document  
        document.open();  
        // 4-往 Document 添加内容  
        document.add(new Paragraph("ThirdteenDevil"));  
        // 5-关闭 Document  
        document.close();  
		System.out.println("success");
	}
	
	
	
	@Test
	//文档对象：Document、Rectangle、PageSize
	/*
	1、 Document — PDF对象
		1）构造方法：
			a、Document(Rectangle pageSize, float marginLeft, float marginRight, float marginTop,float marginBottom)：分别指pdf页面大小和内容距离文档边的距离。
			b、默认 Document()为：A4，36，36，36，36
		2）属性：
			a、基本属性：版本（PdfVersionImp）、标题（Title）、作者（Author）、主题（Subject）、关键字（Keywords）、创建者（Creator）等等
			b、其他属性：页面空白（Margins和marginLeft各个方位）
		3）方法：
			a、 add()-添加内容，newPage()-下一页， addDocListener-监听器
			b 、getPageNumber()-第几页 ，getPageSize-页面大小 ，top|left|right|bottom-页面预定义位置，置页眉页脚或者页码时有用，内部调用Rectangle的属性setJavaScript_onLoad（添加js）等等
	*/
	public void test02createPdf() throws Exception{
		// 2-2 横向打印  
        document = new Document(PageSize.A4.rotate());// 横向打印  
  
        try {  
        	OutputStream out = new FileOutputStream(new File(outputFile));
            // 解析器  
            PdfWriter writer= PdfWriter.getInstance(document, out);  
  
            // 3-为pdf添加属性信息  
            document.addAuthor("作者");  
            document.addTitle("标题");  
            document.addSubject("主题");  
            document.addKeywords("关键字");  
              
            //页边空白    
            document.setMargins(10, 20, 30, 40);    
              
            document.open();  
              
            // 4-PDF添加内容  
            document.add(new Paragraph("ThirdteenDevil"));  
              
              
            // 5-添加Page  
            document.newPage();    
//          writer.setPageEmpty(false);//显示空内容的页  
            writer.setPageEmpty(true);//不会显示空内容的页  
                
            document.newPage();    
            document.add(new Paragraph("New page"));    
            document.close(); 
            System.out.println("success");
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
	
	
	
	@Test
	public void test03createPdf() throws Exception{
		OutputStream out = new FileOutputStream(new File(outputFile));
		 // 1- 页面的属性  
        Rectangle tRectangle = new Rectangle(PageSize.A4); // 页面大小  
         tRectangle = new Rectangle(0, 0, 800, 600);  
  
        tRectangle.setBackgroundColor(Color.ORANGE); // 页面背景色  
        tRectangle.setBorder(1220);// 边框  
        tRectangle.setBorderColor(Color.BLUE);// 边框颜色  
        tRectangle.setBorderWidth(244.2f);// 边框宽度  
  
        Document doc = new Document(tRectangle);// 定义文档  
        doc = new Document(tRectangle.rotate());// 横向打印  
  
        PdfWriter writer = PdfWriter.getInstance(doc, out);// 书写器  
  
        // PDF版本(默认1.4)  
        writer.setPdfVersion(PdfWriter.PDF_VERSION_1_2);  
  
        // 2-PDF文档属性  
        doc.addTitle("Title@sample");// 标题  
        doc.addAuthor("Author@rensanning");// 作者  
        doc.addSubject("Subject@iText sample");// 主题  
        doc.addKeywords("Keywords@iText");// 关键字  
        doc.addCreator("Creator@iText");// 谁创建的  
  
        // 3-综合属性：  
        doc.setMargins(10, 20, 30, 40);// 页边空白  
  
        doc.open();// 打开文档  
        doc.add(new Paragraph("Hello World"));// 添加内容  
  
        // 4-添加下一页  
        doc.newPage();  
        writer.setPageEmpty(true);// fasle-显示空内容的页;true-不会显示  
  
        doc.newPage();  
        doc.add(new Paragraph("New page"));  
        doc.close();  
        System.out.println("success");
	}
	
	
	
	@Test
	/*
	 * （三）内容对象：
	 *	1、中文支持：
	 *	1）BaseFont-确认支持中文
	 *	2）Font-字体的设置，如颜色，字体，大小等
	 *	3）固定用法如下：
	 */
	public void test04createFont() throws Exception{
		 	BaseFont bfChinese;  
	        Font fontChinese = null;
	        try {  
	        	String fontPath = "E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext" + File.separator + "simsun-bold.ttf";
	            bfChinese = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);  
	            // fontChinese = new Font(bfChinese, 12, Font.NORMAL);  
	            fontChinese = new Font(bfChinese, 12, Font.NORMAL, Color.BLUE);
	        } catch (DocumentException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        
	        
	       OutputStream out = new FileOutputStream(new File(outputFile));
	       document = new Document(PageSize.A4, 50, 50, 50, 50);  
	       PdfWriter.getInstance(document,out);  
	       document.open();  
	       document.add(new Paragraph("ThirdteenDevil",fontChinese));  
	       document.close();  
		   System.out.println("success");
	}
	
	
	@Test
	/*
	 * 2、Element接口
		1）内容对象基本都实现这个接口。如Chunk、 Phrase、 Paragraph
		2）一些有用的方位参数： 
		ALIGN_LEFT， ALIGN_CENTER、 ALIGN_RIGHT， ALIGN_JUSTIFIED 。
		如设置居中对齐：setAlignment(Element.ALIGN_CENTER)
		3、 Chunk
		1）块对象: a String, a Font, and some attributes
		2）方法：Chunk.NEWLINE-换行，
		setUnderline(0.2f, -2f)- 下划线
		setTextRise(6)-上浮
	 */
	public void test05createElement() throws Exception{
		OutputStream out = new FileOutputStream(new File(outputFile));
	    document = new Document(PageSize.A4, 50, 50, 50, 50);  
	    PdfWriter.getInstance(document,out);  
	    document.open();  
	    
	    document.add(new Chunk("中文输出： ", getChineseFont()));  
        Chunk tChunk2 = new Chunk("输出的内容", getChineseFont());  
        tChunk2.setBackground(Color.CYAN, 1f, 0.5f, 1f, 1.5f); // 设置背景色  
        tChunk2.setTextRise(6); // 上浮  
        tChunk2.setUnderline(0.2f, -2f); // 下划线  
        document.add(tChunk2);  
        document.add(Chunk.NEWLINE); // 新建一行  
        
        // ---------------------------- 分割线  -----------------------------
        
        
	    Phrase tPhrase = new Phrase();  
        Chunk name = new Chunk("China");  
        name.setUnderline(0.2f, -2f);  
        tPhrase.add(name);  
        tPhrase.add(Chunk.NEWLINE);// 放在容器中好用  
        tPhrase.add(new Chunk("换行了 :", getChineseFont()));  
        tPhrase.add(new Chunk("chinese"));  
        tPhrase.setLeading(14f);// 行间距  
        document.add(tPhrase);  
  
        // 这边就好用，上面是Chunk，就不好用  
        // 放在段落或短语中又好用  
        document.add(Chunk.NEWLINE);  
  
        Phrase director2 = new Phrase();  
        Chunk name2 = new Chunk("换行了---Japan", getChineseFont());  
        name2.setUnderline(0.2f, -2f);  
        director2.add(name2);  
        director2.add(new Chunk(","));  
        director2.add(new Chunk(" "));  
        director2.add(new Chunk("japanese上浮下", getChineseFont()).setTextRise(3f));  
        director2.setLeading(24);  
        document.add(director2); 
        
        // ---------------------------- 分割线  -----------------------------
        
        document.add(new Paragraph("Paragraph page"));  
        Paragraph info = new Paragraph();  
        info.add(new Chunk("China "));  
        info.add(new Chunk("chinese"));  
        info.add(Chunk.NEWLINE); // 好用的  
        info.add(new Phrase("Japan "));  
        info.add(new Phrase("japanese"));  
        info.setSpacingAfter(10f);// 设置段落下空白  
        document.add(info);  
  
        // 段落是比较好用的  
        Paragraph tParagraph = new Paragraph("段落是文章中最基本的单位。内容上它具有一个相对完整的意思；在文章中，段具有换行的标。段是由句子或句群组成的，在文章中用于体现作者的思路发展或全篇文章的层次。有的段落只有一个句子，称为独句段，独句段一般是文章的开头段、结尾段、"  
                + "过渡段强调段等特殊的段落。多数段落包括不止一个句子或句群，叫多句段。中文段落开头前一般空两个格。", getChineseFont());  
        tParagraph.setAlignment(Element.ALIGN_JUSTIFIED);// 对齐方式  
  
        tParagraph.setIndentationLeft(12);// 左缩进  
        tParagraph.setIndentationRight(12);// 右缩进  
        tParagraph.setFirstLineIndent(24);// 首行缩进  
  
        tParagraph.setLeading(20f);// 行间距  
        tParagraph.setSpacingBefore(5f);// 设置上空白  
        tParagraph.setSpacingAfter(10f);// 设置段落下空白  
        document.add(tParagraph);  
  
        // 每个新的段落会另起一行  
        tParagraph = new Paragraph("新的段落", getChineseFont());  
        tParagraph.setAlignment(Element.ALIGN_CENTER);// 居中  
        document.add(tParagraph);  
        
        
        document.close();
		System.out.println("success");
	}
	
	
	@Test
	/*
	 * Image继承自Rectangle
	 *	1）、初始化：Image img = Image.getInstance("source/imag/bage.png")
	 *	2）、方法：
	 *	setAlignment(Image.LEFT)-对齐方式，setBorder(Image.BOX)-边框，
	 *	setBorderWidth(10)-边框宽度，setBorderColor(BaseColor.WHITE)-边框颜色，  
	 *	scaleToFit(1000, 72)-大小，setRotationDegrees(-30)-旋转，
	 *	setAbsolutePosition()-绝对位置
	 */
	public void test06createImages() throws Exception{
		OutputStream out = new FileOutputStream(new File(outputFile));
	    document = new Document(PageSize.A4, 0, 0, 0, 0);  
	    PdfWriter.getInstance(document,out);  
	    document.open();  
        
	    Image img = Image.getInstance("E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext//aa.jpg");
		
        img.setAlignment(Image.LEFT);  
        img.setBorder(Image.BOX);  
        img.setBorderWidth(10);  
        img.setBorderColor(Color.BLACK);  
        img.scaleToFit(1000, 72);// 大小  
        img.setRotationDegrees(-30);// 旋转  
        img.setAbsolutePosition(100, 200);
        document.add(img);
        // ---------------------------- 分割线  -----------------------------
        
        document.close();
		System.out.println("success");
	}
	
	
	
	
	
	@Test
	//Anchor（锚点、超链接） 、Chapter、Section（目录章节）等
	 public void test07insertObject() throws Exception {  
		OutputStream out = new FileOutputStream(new File(outputFile));
        Document document = new Document(PageSize.A4);  
        PdfWriter.getInstance(document, out);  
        document.open();  
  
        // Anchor超链接和锚点对象: internal and external links  
        Paragraph country = new Paragraph();  
        Anchor dest = new Anchor("我是锚点，也是超链接", getChineseFont());  
        dest.setName("CN"); // 设置锚点的名字  
        dest.setReference("http://www.china.com");// 连接  
        country.add(dest);  
        country.add(String.format(": %d sites", 10000));  
        document.add(country);  
  
        Anchor toUS = new Anchor("连接到设置的CN锚点。", getChineseFont());  
        toUS.setReference("#CN");// 取到锚点  
        document.add(toUS);  
  
        // 图片Image对象  
        Image img = Image.getInstance("E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext//aa.jpg");
		
        img.setAlignment(Image.LEFT);  
        img.setBorder(Image.BOX);  
        img.setBorderWidth(10);  
        img.setBorderColor(Color.WHITE);  
        img.scaleToFit(1000, 72);// 大小  
        img.setRotationDegrees(-30);// 旋转  
        document.add(img);  
  
        // Chapter, Section对象（目录对象）  
        Paragraph title = new Paragraph("一级标题", getChineseFont());  
        Chapter chapter = new Chapter(title, 1);  
  
        Paragraph title2 = new Paragraph("二级标题1", getChineseFont());  
        Section section = chapter.addSection(title2);  
        section.setBookmarkTitle("bmk");// 左边目录显示的名字，不写就默认名  
        section.setIndentation(30);  
        section.setIndentationLeft(5);  
        section.setBookmarkOpen(false);  
        section.setNumberStyle(Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);  
  
        Section section2 = chapter.addSection(new Paragraph("二级标题2", getChineseFont()));  
        section2.setIndentation(30);  
        section2.setIndentationLeft(5);  
        section2.setBookmarkOpen(false);  
        section2.setNumberStyle(Section.NUMBERSTYLE_DOTTED_WITHOUT_FINAL_DOT);  
  
        Section subsection = section.addSection(new Paragraph("三级标题1", getChineseFont()));  
        subsection.setIndentationLeft(10);  
        // subsection.setNumberDepth(1);  
        subsection.setNumberStyle(Section.NUMBERSTYLE_DOTTED);  
  
        Section subsection2 = section2.addSection(new Paragraph("三级标题2", getChineseFont()));  
        subsection2.setIndentationLeft(10);  
        subsection2.setNumberStyle(Section.NUMBERSTYLE_DOTTED);  
        document.add(chapter);  
  
        document.close();  
	  
    }  
	
	
	
	@Test
	/**
	 * （四）、表格对象：Table、PdfPTable
		1、构造方法：
		PdfPTable datatable = new PdfPTable(6)；//列数
		PdfPTable datatable = new PdfPTable(new float[]{1,2,3})-每个单元格宽度
		2、结构：
		PdfPTable[PdfPTable[PdfPCell[Paragraph]]]
		3、方法：
		1） setWidths(数组)-单元格宽度， setTotalWidth(300f)-表格的总宽度，
		setWidthPercentage(100)-表格的宽度百分比，setLockedWidth(true)-宽度锁定
		2） getDefaultCell()-得到默认单元格，addCell()-添加单元格
		setPadding(2)-单元格的间隔 ，setBackgroundColor(BaseColor.GREEN)-背景色
		3） setSpacingAfter(40f)-设置表格下面空白行， setSpacingBefore(20f)-设置表格上面空白行
		new Paragraph(“\n\n”)-可以实现换行，留白
		4）setBorderWidth(2)-边框宽度
		5）setHorizontalAlignment(Element.ALIGN_CENTER)-对齐方式
		6）写入绝对位置：
		    PdfContentByte tContent = writer.getDirectContent()-得到层    
		    table.writeSelectedRows(0,-1, 0, -1, 100, 200, tContent)-写入绝对位置
	 */
	public void test08createTable() throws Exception {  
		OutputStream out = new FileOutputStream(new File(outputFile));
		 Document document = new Document(PageSize.A4, 50, 50, 50, 50);  
	        // 使用PDFWriter进行写文件操作  
	        PdfWriter.getInstance(document, out);  
	        document.open();  
	  
	        int colNumber = 6;  
	  
	        // PdfPTable[PdfPTable[PdfPCell[Paragraph]]]  
	        // 创建有6列的表格  
	        PdfPTable datatable = new PdfPTable(colNumber);  
	        // 定义表格的宽度  
	        int[] cellsWidth = { 1, 1, 1, 1, 1, 1 };  
	        datatable.setWidths(cellsWidth);// 单元格宽度  
	        // datatable.setTotalWidth(300f);//表格的总宽度  
	        datatable.setWidthPercentage(100);// 表格的宽度百分比  
	  
	        datatable.getDefaultCell().setPadding(2);// 单元格的间隔  
	        datatable.getDefaultCell().setBorderWidth(2);// 边框宽度  
	        // 设置表格的底色  
	        datatable.getDefaultCell().setBackgroundColor(Color.GREEN);  
	        datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);  
	  
	        // PdfPTable[PdfPCell[Paragraph]]  
	        // 添加表头元素  
	        for (int i = 0; i < colNumber; i++) {  
	            datatable.addCell(new Paragraph("Title", getChineseFont()));  
	        }  
	        // 添加表格的内容  
	        for (int i = 0; i < colNumber; i++) {  
	            datatable.addCell(new Paragraph("内容", getChineseFont()));  
	        }  
	  
	        // 空白表格  
	        for (int i = 0; i < colNumber; i++) {  
	            PdfPCell cell = new PdfPCell(new Paragraph(""));  
	            cell.setFixedHeight(10);// 单元格高度  
	            datatable.addCell(cell);  
	        }  
	        datatable.setSpacingAfter(40f);// 设置表格下面空白行  
	        document.add(datatable);// 把表格加入文档  
	  
	        // 跨行跨列表格  
	        PdfPTable table = new PdfPTable(3); // 3列表格  
	        PdfPCell cell; // 单元格  
	        cell = new PdfPCell(new Phrase("跨3列", getChineseFont()));  
	        cell.setColspan(3);// 跨3列  
	        table.addCell(cell);  
	  
	        cell = new PdfPCell(new Phrase("跨2行", getChineseFont()));  
	        cell.setRowspan(2);// 跨2行  
	        table.addCell(cell);  
	        table.addCell("row 1; cell 1");  
	        table.addCell("row 1; cell 2");  
	        table.addCell("row 2; cell 1");  
	        table.addCell("row 2; cell 2");  
	  
	        document.add(table);  
	  
	        // 表格的嵌套  
	        PdfPTable tableFather = new PdfPTable(4);  
	        tableFather.setSpacingBefore(20f);// 设置表格上面空白行  
	        // 1行2列  
	        PdfPTable nested1 = new PdfPTable(2);  
	        nested1.addCell("1.1");  
	        nested1.addCell("1.2");  
	        // 2行1列  
	        PdfPTable nested2 = new PdfPTable(1);  
	        nested2.addCell("2.1");  
	        nested2.addCell("2.2");  
	  
	        // 将表格插入到指定位置  
	        for (int k = 0; k < 12; ++k) {  
	            if (k == 1) {  
	                tableFather.addCell(nested1);  
	            } else if (k == 6) {  
	                tableFather.addCell(nested2);  
	            } else {  
	                tableFather.addCell("cell " + k);  
	            }  
	        }  
	        document.add(tableFather);  
	  
	        document.close();  
	}  
	
	
	
	@Test
	/**
	 * （五）、单元格对象： PdfPCell 
		1、构造函数
		PdfPCell cell= new PdfPCell(new Paragraph(“表格”, 中文支持）
		2、方法
		1）setBackgroundColor(BaseColor.CYAN)-背景色
		2）setMinimumHeight(30f)-最小高度
		setFixedHeight(40f)-固定高度。表格的高度通过单元格高度完成
		3）setBorder(Rectangle.NO_BORDER)-无边框，setBorderWidth(0)-无边框。不设，默认是有边框的
		setBorderColor(new BaseColor(255, 0, 0))-边框颜色
		4）setHorizontalAlignment(Element.ALIGN_CENTER)-水平居中
		setVerticalAlignment(Element.ALIGN_MIDDLE)-垂直居中。设置单元格内容的显示
		5）setRowspan(2)-跨2行，setColspan(2)-跨2列
	 */
	public void test09createTable() throws Exception{
		OutputStream out = new FileOutputStream(new File(outputFile));
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);  
        // 使用PDFWriter进行写文件操作  
        PdfWriter.getInstance(document, out);  
        document.open();  
  
  
        int colNumber = 6;  
  
        // PdfPTable[PdfPTable[PdfPCell[Paragraph]]]  
        // 创建有6列的表格  
        PdfPTable datatable = new PdfPTable(colNumber);  
        // 定义表格的宽度  
        int[] cellsWidth = { 1, 1, 1, 1, 1, 1 };  
        datatable.setWidths(cellsWidth);// 单元格宽度  
        // datatable.setTotalWidth(300f);//表格的总宽度  
        datatable.setWidthPercentage(100);// 表格的宽度百分比  
  
        datatable.getDefaultCell().setPadding(2);// 单元格的间隔  
        datatable.getDefaultCell().setBorderWidth(2);// 边框宽度  
        // 设置表格的底色  
        datatable.getDefaultCell().setBackgroundColor(Color.GREEN);  
        datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);  
  
        // PdfPTable[PdfPCell[Paragraph]]  
        // 添加表头元素  
        for (int i = 0; i < colNumber; i++) {  
            datatable.addCell(new Paragraph("标题", getChineseFont()));  
        }  
        // 添加表格的内容  
        for (int i = 0; i < colNumber; i++) {  
            datatable.addCell(new Paragraph("内容", getChineseFont()));  
        }  
  
        // 空白表格  
        for (int i = 0; i < colNumber; i++) {  
            PdfPCell cell = new PdfPCell(new Paragraph(""));  
            cell.setFixedHeight(10);// 单元格高度  
            datatable.addCell(cell);  
        }  
        datatable.setSpacingAfter(40f);// 设置表格下面空白行  
        document.add(datatable);// 把表格加入文档  
  
        // 跨行跨列表格  
        PdfPTable table = new PdfPTable(3); // 3列表格  
        PdfPCell cell; // 单元格  
        cell = new PdfPCell(new Phrase("跨3列", getChineseFont()));  
        cell.setColspan(3);// 跨3列  
        table.addCell(cell);  
  
        cell = new PdfPCell(new Phrase("跨2行", getChineseFont()));  
        cell.setRowspan(2);// 跨2行  
        table.addCell(cell);  
        table.addCell("row 1; cell 1");  
        table.addCell("row 1; cell 2");  
        table.addCell("row 2; cell 1");  
        table.addCell("row 2; cell 2");  
  
        document.add(table);  
  
        // 表格的嵌套  
        PdfPTable tableFather = new PdfPTable(4);  
        tableFather.setSpacingBefore(20f);// 设置表格上面空白行  
        // 1行2列  
        PdfPTable nested1 = new PdfPTable(2);  
        nested1.addCell("1.1");  
        nested1.addCell("1.2");  
        // 2行1列  
        PdfPTable nested2 = new PdfPTable(1);  
        nested2.addCell("2.1");  
        nested2.addCell("2.2");  
  
        // 将表格插入到指定位置  
        for (int k = 0; k < 12; ++k) {  
            if (k == 1) {  
                tableFather.addCell(nested1);  
            } else if (k == 6) {  
                tableFather.addCell(nested2);  
            } else {  
                tableFather.addCell("cell " + k);  
            }  
        }  
        document.add(tableFather);  
  
        document.close();  
	}
	
	
	@Test
	/**
	 * 
	    1、四层结构
		2、层对象： PdfContentByte
		3、一、四层可操作；二、三层Itext内部处理
		4、 操作：
		⑴ PdfWriter 对象：
		第 1 层操作：PdfWriter. getDirectContent()，
		第 2 层操作：getDirectContentUnder()。
		⑵ PdfStamper 对象
		第 1 层操作： PdfStamper. getUnderContent(1)，-可以加页数
		第 2 层操作： PdfStamper .getOverContent(1)。
		5、作用：添加水印、背景、添加内容到绝对位置、合并PDF
		
		
		(六)、添加水印
		1、方法：
		PdfContentByte under = writer.getDirectContentUnder();//默认当前页
		PdfContentByte under = stamp.getUnderContent(1);// 拿到层,可以有页数
		2、文本水印
		1）beginText()：开始，endText()结束。
		2）showTextAligned()写入文档，这个方法有很多重载，可以添加方位，旋转等。
	 */
	public void test10createWaterStamp() throws Exception{
		OutputStream out = new FileOutputStream(new File(outputFile));
		 Document document = new Document(PageSize.A4);  
	        PdfWriter writer = PdfWriter.getInstance(document, out);  
	        document.open();  
	  
	        /* 
	         * PDF分为四层，第一层和第四层由低级操作来进行操作，第二层、第三层由高级对象操作(从下往上) 
	         * 第一层操作只能使用PdfWriter.DirectContent操作，第四层使用DirectContentUnder操作,。 
	         * 第二层和第三层的PdfContentByte是由IText内部操作，没有提供api接口。 
	         */  
	        PdfContentByte under = writer.getDirectContentUnder();  
	        // under = writer.getDirectContent();  
	  
	        under.beginText();  
	        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);  
	        under.setFontAndSize(bf, 18);  
	        // under.setTextMatrix(30, 30);  
	        under.showTextAligned(Element.ALIGN_LEFT, "ShuiYin................", 230, 430, 45);  
	        under.endText();  
	  
	        document.close();  
	        System.out.println("success");
	}
	
	
	@Test
	/**
	 * 图片水印与背景 
		1）添加水印：
		2）水印与背景的区别：背景只需要把绝对置为从 文档左下角开始。 即设置setAbsolutePosition(0, 0)
		3）位置的定位：理解页面对象——Rectangle
		Rectangle  tRectangle = new Rectangle(0, 0, 800, 600);
	 */
	public void testcreateImageWaterStamp() throws Exception{
		//加完水印生成的PDF
		OutputStream out = new FileOutputStream(new File(outputFile));
		// 读取器   //需要加水印的PDF
        PdfReader reader = new PdfReader("D://deleteme//aaaa.pdf");  
        // 解析器与输出  
        PdfStamper stamp = new PdfStamper(reader, out);  
  
        // 图片水印  
        Image img = Image.getInstance("E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext//aa.jpg");  
        img.setAbsolutePosition(100, 100);// 位置  
        PdfContentByte under = stamp.getUnderContent(1);// 拿到层,页数  
        under.addImage(img);  
  
        // 文字水印  
        PdfContentByte over = stamp.getOverContent(1);// 拿到层,字显示在图片上  
        over.beginText();  
        BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);  
        over.setFontAndSize(bf, 18);  
        over.setTextMatrix(30, 30);  
        over.showTextAligned(Element.ALIGN_LEFT, "ShuiYin", 230, 430, 45);  
        over.endText();  
  
        // 背景图  
        Image img2 = Image.getInstance("E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext//aa.jpg");
        img2.setAbsolutePosition(0, 0);  
        PdfContentByte under2 = stamp.getUnderContent(1);  
        under2.addImage(img2);  
  
        // 关闭  
        stamp.close();  
        reader.close();  
	}
	
	
	public Font getChineseFont() throws Exception{
		BaseFont bfChinese;  
        Font fontChinese = null;
        try {  
        	String fontPath = "E://thdsvn//java_project//javatest-root//javatest-acrobat//src//main//java//com//thd//itext" + File.separator + "simsun-bold.ttf";
            bfChinese = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);  
            // fontChinese = new Font(bfChinese, 12, Font.NORMAL);  
            fontChinese = new Font(bfChinese, 12, Font.NORMAL, Color.BLUE);
            return fontChinese;
        } catch (IOException e) {  
            e.printStackTrace();  
            throw e;
        }  
	}

}
