package com.thd.javatest.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * com.thd.javatest.pdf.T3
 *
 * @author: wanglei62
 * @DATE: 2019/12/18 13:00
 **/
public class PdfWaterMarkUtils {
    public static void main(String[] args) {
        try {
//            List<InputStream> pdfs = new ArrayList<InputStream>();
//            pdfs.add(new FileInputStream("e:\\123.pdf"));
//            pdfs.add(new FileInputStream("e:\\456.pdf"));
//            OutputStream output = new FileOutputStream("e:\\789.pdf");
//            concatPDFs(pdfs, output, true);

            PdfWaterMarkUtils.addPdfImgMark("D:\\deleteme\\pdf\\aa.pdf",
                    "D:\\deleteme\\pdf\\aa2.pdf",
                    "D:\\deleteme\\pdf\\01.png",
                    100,100);
            PdfWaterMarkUtils.addPdfTextMark("D:\\deleteme\\pdf\\aa.pdf",
                    "D:\\deleteme\\pdf\\aa3.pdf", "水印文字", 100,
                    100);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File mergeFiles(String[] files, String result, boolean smart) throws IOException, DocumentException {
        Document document = new Document();
        PdfCopy copy;
        if (smart)
            copy = new PdfSmartCopy(document, new FileOutputStream(result));
        else
            copy = new PdfCopy(document, new FileOutputStream(result));
        document.open();
        PdfReader[] reader = new PdfReader[files.length];
        for (int i = 0; i < files.length; i++) {
            reader[i] = new PdfReader(files[i]);
            copy.addDocument(reader[i]);
            copy.freeReader(reader[i]);
            reader[i].close();
        }
        document.close();
        return new File(result);
    }

    /**
     * 合并pdf
     *
     * @param streamOfPDFFiles
     * @param outputStream
     * @param paginate
     */
    public static void concatPDFs(List<InputStream> streamOfPDFFiles,
                                  OutputStream outputStream, boolean paginate) {

        Document document = new Document();
        try {
            List<InputStream> pdfs = streamOfPDFFiles;
            List<PdfReader> readers = new ArrayList<PdfReader>();
            int totalPages = 0;
            Iterator<InputStream> iteratorPDFs = pdfs.iterator();

            // Create Readers for the pdfs.
            while (iteratorPDFs.hasNext()) {
                InputStream pdf = iteratorPDFs.next();
                PdfReader pdfReader = new PdfReader(pdf);
                readers.add(pdfReader);
                totalPages += pdfReader.getNumberOfPages();
            }
            // Create a writer for the outputstream
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);

            document.open();
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,
                    BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            PdfContentByte cb = writer.getDirectContent(); // Holds the PDF
            // data

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

    /**
     *
     * <br>
     * <p>
     * Description: 给pdf文件添加水印 <br>
     * <p><br/>
     * <p>
     *
     * @param InPdfFile
     *            要加水印的原pdf文件路径
     * @param outPdfFile
     *            加了水印后要输出的路径
     * @param markImagePath
     *            水印图片路径
     * @param imgWidth
     *            图片横坐标
     * @param imgHeight
     *            图片纵坐标
     * @throws Exception
     */
    public static void addPdfImgMark(String InPdfFile, String outPdfFile, String markImagePath,int imgWidth, int imgHeight) throws Exception {
        PdfReader reader = new PdfReader(InPdfFile, "PDF".getBytes());
        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(new File(outPdfFile)));

        PdfContentByte under;

        PdfGState gs1 = new PdfGState();
        gs1.setFillOpacity(0.3f);// 透明度设置

        Image img = Image.getInstance(markImagePath);// 插入图片水印

        img.setAbsolutePosition(imgWidth, imgHeight); // 坐标
        img.setRotation(-20);// 旋转 弧度
        img.setRotationDegrees(45);// 旋转 角度
        // img.scaleAbsolute(200,100);//自定义大小
        // img.scalePercent(50);//依照比例缩放

        int pageSize = reader.getNumberOfPages();// 原pdf文件的总页数
        for(int i = 1; i <= pageSize; i++) {
            under = stamp.getUnderContent(i);// 水印在之前文本下
            // under = stamp.getOverContent(i);//水印在之前文本上
            under.setGState(gs1);// 图片水印 透明度
            under.addImage(img);// 图片水印
        }

        stamp.close();// 关闭
        // // 删除不带水印文件
//		File tempfile = new File(InPdfFile);
//		if(tempfile.exists()) {
//			tempfile.delete();
//		}

    }

    /**
     *
     * <br>
     * <p>
     * Description: 给pdf文件添加水印<br>
     *
     * @param InPdfFile
     *            要加水印的原pdf文件路径
     * @param outPdfFile
     *            加了水印后要输出的路径
     * @param textMark
     *            水印文字
     * @param textWidth
     *            文字横坐标
     * @param textHeight
     *            文字纵坐标
     * @throws Exception
     */
    public static void addPdfTextMark(String InPdfFile, String outPdfFile, String textMark,int textWidth,
                                      int textHeight) throws Exception {
        PdfReader reader = new PdfReader(InPdfFile, "PDF".getBytes());
        PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(new File(outPdfFile)));

        PdfContentByte under;

        BaseFont font = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1", "Identity-H", true);// 使用系统字体

        int pageSize = reader.getNumberOfPages();// 原pdf文件的总页数

        PdfGState gs = new PdfGState();
        gs.setFillOpacity(0.8f);// 设置透明度为0.8



        for(int i = 1; i <= pageSize; i++) {

           // under = stamp.getUnderContent(i);// 水印在之前文本下
            under = stamp.getOverContent(i);//水印在之前文本上

            under.setGState(gs);//透明度
            under.beginText();
            under.setColorFill(BaseColor.BLACK);// 文字水印 颜色
            under.setFontAndSize(font, 10);// 文字水印 字体及字号
            under.setTextMatrix(textWidth, textHeight);// 文字水印 起始位置
            //对其方式, 文字内容,宽,高,倾斜角度
            under.showTextAligned(Element.ALIGN_CENTER, textMark, textWidth, textHeight, 0);
            under.endText();
        }

        stamp.close();// 关闭
    }
}
