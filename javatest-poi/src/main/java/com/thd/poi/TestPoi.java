package com.thd.poi;

import com.thd.poi.util.PoiUtils;
import junit.framework.TestCase;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.junit.Test;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * com.thd.poi.Test
 *
 * @author: wanglei62
 * @DATE: 2020/6/2 13:46
 **/

public class TestPoi extends TestCase {
    @Test
    public void test01() throws Exception {
        System.out.println("test");

//        String filePath = "D:\\devil13th\\github\\javatest-root\\javatest-poi\\src\\main\\java\\com\\thd\\poi\\datab.xlsx";
        String filePath = "D:\\deleteme\\Painting Daily ORT Template.xlsx";

        if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
            System.out.println("文件不是excel类型");
        }

        FileInputStream fis = null;
        Workbook wookbook = null;
        Sheet sheet = null;

        //获取一个绝对地址的流
        fis = new FileInputStream(filePath);

        try {
            //2003版本的excel，用.xls结尾
            wookbook = new HSSFWorkbook(fis);//得到工作簿
        } catch (Exception ex) {
            //ex.printStackTrace();
            try {
                //2007版本的excel，用.xlsx结尾
                fis = new FileInputStream(filePath);
                wookbook = new XSSFWorkbook(fis);//得到工作簿
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        Map<String, PictureData> maplist=null;

        sheet = wookbook.getSheetAt(0);

        //获得数据的总行数
        int totalRowNum = sheet.getLastRowNum();
        System.out.println(String.format(" 总计：%d 行 ",totalRowNum) );
        // 读取第一行数据
        Row rowHead = sheet.getRow(0);
        // 读取第一行的列数
        int totalColNum = rowHead.getLastCellNum();

        System.out.println(String.format(" 第一行有 %d 列",totalColNum));

        Cell cell00 = rowHead.getCell(0);
        System.out.println( cell00.getStringCellValue());

        Cell cell01 = rowHead.getCell(1);
        System.out.println( cell01.getStringCellValue());



        System.out.println("============= 读取excel数据 ================");

        for(int i = 0 , j = totalRowNum ; i <= j ; i++){
            Row row = sheet.getRow(i);
            System.out.print(String.format("读取第%s行 , ",i));
            if(null == row){
                continue;
            }
            int columnNum = row.getLastCellNum();
            System.out.println(String.format("总计%s列",columnNum));

            Object value = null;
            for(int x = 0 , y = columnNum ; x < y ; x++){
                Cell cell = row.getCell(x);
                if(cell == null){
                    continue;
                }
                System.out.println("  类型 ： " + cell.getCellType() );
                switch (cell.getCellType()) {
                    case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                        //如果为时间格式的内容
                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
                            //注：format格式 yyyy-MM-dd hh:mm:ss 中小时为12小时制，若要24小时制，则把小h变为H即可，yyyy-MM-dd HH:mm:ss
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                            value=sdf.format(HSSFDateUtil.getJavaDate(cell.
                                    getNumericCellValue())).toString();
                            break;
                        } else {
                            value = new DecimalFormat("0").format(cell.getNumericCellValue());
                        }
                        break;
                    case HSSFCell.CELL_TYPE_STRING: // 字符串
                        value = cell.getStringCellValue();
                        break;
                    case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                        value = cell.getBooleanCellValue() + "";
                        break;
                    case HSSFCell.CELL_TYPE_FORMULA: // 公式
                        value = cell.getCellFormula() + "";
                        break;
                    case HSSFCell.CELL_TYPE_BLANK: // 空值
                        value = "";
                        break;
                    case HSSFCell.CELL_TYPE_ERROR: // 故障
                        value = "非法字符";
                        break;
                    default:
                        value = "未知类型";
                        break;
                }



                System.out.println(String.format("  读第%s列的 类型=%s，值=:%s",x,cell.getCellType(),value));
            }
        }


        System.out.println("============= 读取excel照片 ================");
        //======================= 获取图片 ============================//


        Map<String, PictureData> m = new HashMap<String, PictureData>();
        try{
            XSSFSheet xssfSheet = (XSSFSheet)sheet;
            m = PoiUtils.getPictures2(xssfSheet);
            System.out.println("读取图片成功");
        }catch(Exception e) {
            HSSFSheet hssfSheet = (HSSFSheet)sheet;
            m = PoiUtils.getPictures1(hssfSheet);
            System.out.println("读取图片成功");
        }
        System.out.println(m);
        PoiUtils.printImg(m);

    }








}
