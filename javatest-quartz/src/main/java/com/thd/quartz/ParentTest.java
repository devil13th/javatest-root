/** 
 * Class Description:########
 * Date : 2016年12月15日 上午9:46:44
 * Auth : wanglei 
*/  

package com.thd.quartz;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class ParentTest extends TestCase {
	//Before在每个测试类中最多只能出现一次，可以没有，一般做初始化工作，方法名称命名为setUp.  
	
	public SchedulerFactory schedulerFactory;
	public Scheduler scheduler;
	public Logger log = Logger.getLogger(this.getClass());
    @Before  
    public void setUp() throws Exception{  
        System.out.println(" ---------------------- setUp() -----------------------");  
        schedulerFactory = new StdSchedulerFactory();
        scheduler = schedulerFactory.getScheduler();
		
    }  
    
    public void testinit(){
    	log.info(schedulerFactory);
    	log.info(scheduler);
    	System.out.println("success");
    }
    @After  
    public void tearDown()  throws Exception{  
        System.out.println(" ----------------------- tearDown() -------------------");  
    }  
}
