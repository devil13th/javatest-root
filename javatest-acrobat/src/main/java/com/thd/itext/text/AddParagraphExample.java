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

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class AddParagraphExample {
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
        
        doc.open();
        
        
        
        //构建一段落
        Paragraph par3=new Paragraph("xxxxx",ChineseFont());
        //设置局中对齐
        par3.setAlignment(Element.ALIGN_CENTER);
        //添加到文档
        doc.add(par3);
        
       
        
        
        //行高20的段落
        Paragraph paragraph = new Paragraph();
        //设置行高
        paragraph.setLeading(20);
        //对齐方式
        paragraph.setAlignment(Element.ALIGN_LEFT);
        //首字缩进
        paragraph.setFirstLineIndent(20);
        
        //段前段后距离
        paragraph.setSpacingAfter(10f);
        paragraph.setSpacingBefore(100f);
        
        //插入十条文本块到段落中  
        int i=0;  
        for(i=0; i<10; i++){  
        	// \n为换行符号
          Chunk chunk = new Chunk("世界你好 \n This is a sentence which is long " + i + ". ",ChineseFont());  
          chunk.setBackground(Color.red);
          
          if(i==3){
        	  //设置下划线
        	  /*
        	  public Chunk setUnderline(java.awt.Color color,
                          float thickness,
                          float thicknessMul,
                          float yPosition,
                          float yPositionMul,
                          int cap)
        	  Parameters:
        		  color - the color of the line or null to follow the text color
        		  thickness - the absolute thickness of the line
        		  thicknessMul - the thickness multiplication factor with the font size
        		  yPosition - the absolute y position relative to the baseline
        		  yPositionMul - the position multiplication factor with the font size
        		  cap - the end line cap. Allowed values are PdfContentByte.LINE_CAP_BUTT, PdfContentByte.LINE_CAP_ROUND and PdfContentByte.LINE_CAP_PROJECTING_SQUARE
        	 */
        	  chunk.setUnderline(Color.BLACK,0.1f, 0f, -1f, 0f, 0);
        	  
        	  //设置倾斜度
        	  /*
        	  public Chunk setSkew(float alpha,float beta)
			  Skews the text to simulate italic and other effects. Try alpha=0 and beta=12.
			  Parameters:
			  alpha - the first angle in degrees  - 整个行倾斜角度
			  beta - the second angle in degrees  - 每个字倾斜度
			  */
        	  chunk.setSkew(0, 25);
          }
          paragraph.add(chunk);  
        } 
        doc.add(paragraph);
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
        
        /**
         * 创建字体
         * 参数1：字体
         * 参数2：字体大小
         * 参数3：是否粗体  Font.NORMAL  Font.BOLD
         * 参数4：字体颜色
         */
        
        Font chineseFont=new Font(baseFont,8,Font.NORMAL,Color.BLUE);
        return chineseFont;
    }


}
