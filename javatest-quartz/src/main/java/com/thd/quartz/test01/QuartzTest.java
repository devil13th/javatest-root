package com.thd.quartz.test01;

import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;
import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import com.thd.quartz.JobTest;

public class QuartzTest {
	
	public static void main(String[] args)  {
		try{
			//调度器（工厂模式）
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			
			//Trigger触发器：执行任务的规则；比如每天，每小时等。
			//Date runTime = DateBuilder.evenMinuteDate(new Date());
			//Trigger trigger_1 = newTrigger().withIdentity("task_1","group_1").startAt(runTime).build(); 
			
			
			//一般情况使用SimpleTrigger，和CronTrigger，这个触发器实现了Trigger接口。
			//对于复杂的时间表达式来说，比如每个月15日上午几点几分，使用CronTrigger
			//对于简单的时间来说，比如每天执行几次，使用SimpleTrigger
			//scheduler任务调度：是最核心的概念，需要把JobDetail和Trigger注册到scheduler中，才可以执行。
			CronTrigger trigger_1 = newTrigger().withIdentity("task_1", "group_1").withSchedule(CronScheduleBuilder.
					cronSchedule("0/1 * * * * ?")).build(); 
			
			// 创建jobDetail实例，绑定Job实现类  
			// 指明job的名称，所在组的名称，以及绑定job类 
			JobDetail jobDetail_1 = JobBuilder.newJob(JobTest.class).withIdentity("job_1", "group_1").build();
			
			//CronTrigger trigger_2 = newTrigger().withIdentity("task_2", "group_1").withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build(); 
			
			
			
			
			//相应的具体任务
			//JobDetail jobDetail_2 = JobBuilder.newJob(JobTest.class).withIdentity("job_2", "group_1").build();
			
			//组装组件
			scheduler.scheduleJob(jobDetail_1, trigger_1);
			//scheduler.scheduleJob(jobDetail_2, trigger_2);
			System.out.println("调度器组装组件完成");
			scheduler.start();
			
			//获取触发器
//			TriggerKey triggerKey = TriggerKey.triggerKey("task_1", "group_1");
//			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
//			System.out.println(trigger);
			
			
//			Thread.sleep(5000);
//			if(trigger!=null){
//				//更新任务
//				// trigger已存在，则更新相应的定时设置
//				CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/3 * * * * ?");
//				// 按新的cronExpression表达式重新构建trigger
//				trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
//				// 按新的trigger重新设置job执行
//				scheduler.rescheduleJob(triggerKey, trigger);
//				
//				//暂停任务
//				JobKey p_jobKey = JobKey.jobKey("job_1", "group_1");
//				scheduler.pauseJob(p_jobKey);
//				//恢复任务
//				JobKey r_jobKey = JobKey.jobKey("job_1", "group_1");
//				scheduler.resumeJob(r_jobKey);
				//删除任务
//				JobKey d_jobKey = JobKey.jobKey("job_1", "group_1");
//				scheduler.deleteJob(d_jobKey);
//				//立即执行任务
//				JobKey t_jobKey = JobKey.jobKey("job_1", "group_1");
//				scheduler.triggerJob(t_jobKey);
//				
//			}
			
			
			
			//获取所有的定时任务
//			for(String groupName : scheduler.getJobGroupNames()) {
//				for(JobKey jobKey : scheduler.getJobKeys(GroupMatcher.groupEquals(groupName))) {
//					String jobName = jobKey.getName();
//					String jobGroup = jobKey.getGroup();
//					
//					List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
//					Date nextFireTime = triggers.get(0).getNextFireTime(); 
//					System.out.println("[jobName] : " + jobName + " [groupName] : "+ jobGroup + " - " + nextFireTime);
//				}
//			}
			
			
			
			//关闭
			//scheduler.shutdown();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
