package com.thd.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * com.thd.excel.ExcelUtils
 *
 * @author: wanglei62
 * @DATE: 2019/11/20 16:35
 **/
public class ExcelUtils {
    public static void test01(){
        POIFSFileSystem fs = null;
        try{
            //fs = new POIFSFileSystem(new File("D:\\work\\dqmDOC\\培训考试试题.xlsx"));

//            InputStream is = new FileInputStream(new File("D:\\work\\dqmDOC\\培训考试试题.xlsx"));
//            fs = new POIFSFileSystem(is);
//            HSSFWorkbook wb = new HSSFWorkbook(fs.getRoot(), true);


            String fileName = "D:\\work\\dqmDOC\\培训考试试题.xlsx";
            // 这里 只要，然后读取第一个sheet 同步读取会自动finish
            EasyExcel.read(fileName, new NoModleDataListener()).sheet().doRead();


//            OPCPackage pkg = OPCPackage.open(new File("file.xlsx"));
//            XSSFWorkbook wb = new XSSFWorkbook(pkg);


            System.out.println(fs);
        }catch(Exception e){
            e.printStackTrace();

        }finally {

        }

    }




    public static void test02(){
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法1：
        String fileName = "D:\\work\\dqmDOC\\培训考试试题.xlsx";

        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DataBean.class, new DataBeanListener()).sheet().doRead();

        System.out.println("=======================================");



        // 写法2：
        fileName = "D:\\work\\dqmDOC\\培训考试试题.xlsx";
        ExcelReader excelReader = EasyExcel.read(fileName, DataBean.class, new DataBeanListener()).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);

        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
    }



    public static void main(String[] args) throws IOException {
        ExcelUtils.test01();
        System.out.println("=======================================");
        ExcelUtils.test02();

    }
}
