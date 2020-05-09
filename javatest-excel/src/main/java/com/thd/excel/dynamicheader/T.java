package com.thd.excel.dynamicheader;

import com.alibaba.excel.EasyExcel;
import com.thd.excel.DemoData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * com.thd.excel.dynamicheader.T
 *
 * @author: wanglei62
 * @DATE: 2020/5/9 10:19
 **/
public class T {
    public static void main(String args[]){
        // excel中的数据
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }

        // 表头
        List<List<String>> headerList = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<String>();
        head0.add("字符串" + System.currentTimeMillis());
        List<String> head1 = new ArrayList<String>();
        head1.add("数字" + System.currentTimeMillis());
        List<String> head2 = new ArrayList<String>();
        head2.add("日期" + System.currentTimeMillis());
        headerList.add(head0);
        headerList.add(head1);
        headerList.add(head2);


        String fileName = "D://deleteme//aaa.xlsx";
        EasyExcel.write(fileName)
                // 这里放入动态头
                .head(headerList).sheet("模板")
                // 当然这里数据也可以用 List<List<String>> 去传入
                .doWrite(list);

    }
}
