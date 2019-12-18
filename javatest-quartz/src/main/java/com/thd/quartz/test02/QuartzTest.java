/** 
 * Class Description:########
 * Date : 2016年12月15日 上午9:48:26
 * Auth : wanglei 
*/  

package com.thd.quartz.test02;

import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;

import com.thd.quartz.JobTest;

public class QuartzTest extends TestCase{
	public SchedulerFactory schedulerFactory;
	public Scheduler scheduler;
	public Logger log = Logger.getLogger(this.getClass());
    @Before  
    public void setUp() throws Exception{  
        System.out.println(" ---------------------- setUp() -----------------------");  
        schedulerFactory = new StdSchedulerFactory();
        scheduler = schedulerFactory.getScheduler();
		
    }  
    
	//创建新的定时任务
	public void testBeginJob() {
		try{
			
			System.out.println(schedulerFactory);
			System.out.println(scheduler);
			
			//创建定时任务
			CronTrigger trigger = newTrigger().withIdentity("task_1", "group_1").withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?")).build();
			TriggerKey triggerKey = TriggerKey.triggerKey("task_1", "group_1");
			JobDetail jobDetail = JobBuilder.newJob(JobTest.class).withIdentity("job_1", "group_1").build();
			scheduler.scheduleJob(jobDetail, trigger);
			
			//开始所有的定时任务
			scheduler.start();
			//停止所有的定时任务
			//scheduler.shutdown();
			
			
			//查看运行状态
			System.out.println("运行状态：" + scheduler.getTriggerState(triggerKey));
			
			
			//睡5 S  否则定时任务执行不了，  JUNIT结束后 定时任务的线程也结束了
			Thread.sleep(5000);
			
			//暂停定时任务
			JobKey p_jobKey = JobKey.jobKey("job_1", "group_1");
			scheduler.pauseJob(p_jobKey);
			System.out.println("定时任务暂停了");
			//查看运行状态
			System.out.println("运行状态：" + scheduler.getTriggerState(triggerKey));
			
			Thread.sleep(2000);
			
			//立即执行一次
			System.out.println("立即执行一次");
			JobKey t_jobKey = JobKey.jobKey("job_1", "group_1");
			scheduler.triggerJob(t_jobKey);
			//查看运行状态
			System.out.println("运行状态：" + scheduler.getTriggerState(triggerKey));
			
			Thread.sleep(5000);
			
			//恢复定时任务
			JobKey r_jobKey = JobKey.jobKey("job_1", "group_1");
			scheduler.resumeJob(r_jobKey);
			System.out.println("定时任务恢复了");
			//查看运行状态
			System.out.println("运行状态：" + scheduler.getTriggerState(triggerKey));
			
			Thread.sleep(3000);
			
			//更新任务
			System.out.println("更新定时任务时间间隔为3秒");
			scheduler.pauseJob(p_jobKey);
			// trigger已存在，则更新相应的定时设置
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/3 * * * * ?");
			// 按新的cronExpression表达式重新构建trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
			// 按新的trigger重新设置job执行
			scheduler.rescheduleJob(triggerKey, trigger);
			//查看运行状态
			System.out.println("运行状态：" + scheduler.getTriggerState(triggerKey));
			
			Thread.sleep(12000);
			
			
			//查询正在执行的定时任务
			System.out.println("查询正在执行的定时任务");
			System.out.println("------------------------------------------");
			List<JobExecutionContext> currentJobs = scheduler.getCurrentlyExecutingJobs();
			for(JobExecutionContext cec : currentJobs){
				System.out.println(cec.getJobDetail().getKey().getGroup() + ":"  + cec.getJobDetail().getKey().getName());
			}
			System.out.println("------------------------------------------");
			
			Thread.sleep(6000);
			
			
			scheduler.pauseJob(p_jobKey);
			System.out.println("定时任务暂停了");
			
			
			//查询正在执行的定时任务
			System.out.println("查询正在执行的定时任务");
			System.out.println("------------------------------------------");
			currentJobs = scheduler.getCurrentlyExecutingJobs();
			for(JobExecutionContext cec : currentJobs){
				System.out.println(cec.getJobDetail().getKey().getGroup() + ":"  + cec.getJobDetail().getKey().getName());
			}
			System.out.println("------------------------------------------");
			
			
			//查询定时任务
			System.out.println("查询定时任务");
			System.out.println("------------------------------------------");
			for(String groupName : scheduler.getJobGroupNames()) {
				for(Object objKey : scheduler.getJobKeys(GroupMatcher.groupEquals(groupName))) {
					JobKey jobKey = (JobKey)objKey;
					String jobName = jobKey.getName();
					String jobGroup = jobKey.getGroup();
					JobDetail jd = scheduler.getJobDetail(jobKey);
					System.out.println("[jobName] : " + jobName + " [groupName] : "+ jobGroup );
					List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
					for(Trigger tg : triggers){
						Date nextFireTime = tg.getNextFireTime(); 
						System.out.println("    [jobName] : " + jobName + " [groupName] : "+ jobGroup + " - " + nextFireTime);
					}
				}
			}
			System.out.println("------------------------------------------");
			
			
			//删除任务
			JobKey d_jobKey = JobKey.jobKey("job_1", "group_1");
			scheduler.deleteJob(d_jobKey);
			System.out.println("定时任务被删除");
			//查看运行状态
			System.out.println("运行状态：" + scheduler.getTriggerState(triggerKey));
			
			
			
			//查询所有定时任务
			System.out.println("查询定时任务");
			System.out.println("------------------------------------------");
			for(String groupName : scheduler.getJobGroupNames()) {
				for(Object objKey : scheduler.getJobKeys(GroupMatcher.groupEquals(groupName))) {
					JobKey jobKey = (JobKey)objKey;
					String jobName = jobKey.getName();
					String jobGroup = jobKey.getGroup();
					JobDetail jd = scheduler.getJobDetail(jobKey);
					System.out.println("[jobName] : " + jobName + " [groupName] : "+ jobGroup );
					List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
					for(Trigger tg : triggers){
						Date nextFireTime = tg.getNextFireTime(); 
						System.out.println("    [jobName] : " + jobName + " [groupName] : "+ jobGroup + " - " + nextFireTime);
					}
				}
			}
			System.out.println("------------------------------------------");
			
			
			
			System.out.println("success");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
}
