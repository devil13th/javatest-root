package com.thd.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 定时任务工厂（公共）
 * Title:
 * Description:
 * @author pxj
 * @date 2016-11-8
 */
public class JobTest implements Job {
	
	private int a = 0;
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		a++;
		System.out.println("执行定时任务 -- [" + a + "]当前时间 ："+sdf.format(new Date()));  
	}

}
