package com.thd.bi.util;

import com.thd.bi.cfg.RtfCfg;
import com.thoughtworks.xstream.XStream;
import oracle.apps.xdo.template.FOProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * com.lenovo.dqm.bi.util.RtfUtils
 *
 * @author: wanglei62
 * @DATE: 2020/2/4 10:13
 **/
@Component
public class RtfUtils {
    @Autowired
    private RtfCfg rtfCfg;

    public String createRandomString(){
        String randomStr = UUID.randomUUID().toString().replace("-","");
        return randomStr;
    }
    public String createRandomFileName(String fileName){
        Calendar cal = Calendar.getInstance();
        Date now = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
        String strDate = format.format(now);
        return strDate + "_" + fileName + "_" + this.createRandomString() ;
    }
//    public String createRandomFileName(String fileSuffix){
//        Calendar cal = Calendar.getInstance();
//        Date now = cal.getTime();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
//        String strDate = format.format(now);
//        return strDate + "_" + this.createRandomString() + "." + fileSuffix;
//    }
    public String createFixFileName(String timeStamp,String fileSuffix){
        return timeStamp + "." + fileSuffix;
    }
    public String createPdf(Object model,String templateName,String fileName){



        String batFileName = this.createRandomFileName(fileName) ;

        //rtf模板名称路径
        String rtfTemplateFilePath = rtfCfg.getRtfTemplateFolderPath() + File.separator + templateName;
        //中间过程生成的xsl路径
        String xslFilePath = rtfCfg.getTempFolderPath() + File.separator + this.createFixFileName(batFileName,"xsl");
        //xml数据文件路径
        String xmlFilePath = rtfCfg.getTempFolderPath() + File.separator + this.createFixFileName(batFileName,"xml");
        //配置文件位路径
        String cfgFilePath = rtfCfg.getXdoFilePath();
        //输出最终文件路径
        String resultPdfFilePath = rtfCfg.getTargetFolderPath() + File.separator + this.createFixFileName(batFileName,"pdf");
        // 输出格式
        byte outputFormat = FOProcessor.FORMAT_PDF;;




        // 生成data xml
        XStream xstream = new XStream();
        //去掉生成xml标签的包名前缀
        xstream.aliasPackage("", "com.lenovo.dqm.bi");

        String hlStr = xstream.toXML(model);
        String outStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
        outStr += hlStr;

        //写入到文件
        FileWriter fw = null;
        File xmlFile = new File(xmlFilePath);
        try {
            if (!xmlFile.exists()) {
                xmlFile.createNewFile();
            }
            fw = new FileWriter(xmlFile);
            //BufferedWriter out = new BufferedWriter(fw,"UTF8");
            OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(xmlFile),"UTF-8");
            BufferedWriter out=new BufferedWriter(write);
            out.write(outStr, 0, outStr.length());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        RtfTemplateUtil util = new RtfTemplateUtil(rtfTemplateFilePath,xslFilePath,xmlFilePath,cfgFilePath,resultPdfFilePath,outputFormat);

        util.generateXdoCfg(rtfCfg.getXdoFilePath(),rtfCfg.getFontFolderPath());
        util.genarateReportPdf();

        return resultPdfFilePath;
    }
}
