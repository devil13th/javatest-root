package com.thd.excel.basic;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * com.thd.excel.NoModleDataListener
 *
 * @author: wanglei62
 * @DATE: 2019/11/20 16:57
 **/
public class NoModleDataListener extends AnalysisEventListener<Map<Integer, String>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(NoModleDataListener.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<Map<Integer, String>> list = new ArrayList<Map<Integer, String>>();

    public void invoke(Map<Integer, String> data, AnalysisContext context) {
       // LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));

        System.out.println(data);
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
//        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        System.out.println("{" + list.size() +"}条数据，开始存储数据库！");
//        LOGGER.info("{}条数据，开始存储数据库！", list.size());
//        LOGGER.info("存储数据库成功！");
    }
}