/** 
 * Class Description:########
 * Date : 2016年11月13日 上午12:15:13
 * Auth : wanglei 
*/  

package com.thd.activiti;

import junit.framework.TestCase;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thd.activiti.myutil.MyActivitiUtil;

public class ActivitiTestCase extends TestCase {
	
	public ClassPathXmlApplicationContext context ;
	public ProcessEngine processEngine  ;
	public RuntimeService runtimeService ;
	public RepositoryService repositoryService ;
	public TaskService taskService  ;
	public ManagementService managementService  ;
	public IdentityService identityService  ;
	public HistoryService historyService  ;
	public FormService formService ;
	public MyActivitiUtil util;
	
	public Logger log = Logger.getLogger(this.getClass());
	
	@Before  
    public void setUp(){
		System.out.println(" ----------------------- setUp() -------------------");  
		util = new MyActivitiUtil("com/thd/activiti/activiti.cfg1.xml");
		ProcessEngine processEngine = util.getProcessEngine();
		RuntimeService runtimeService =util.getRuntimeService();
		RepositoryService repositoryService = util.getRepositoryService();
		TaskService taskService  =util.getTaskService();
		ManagementService managementService =util.getManagementService() ;
		IdentityService identityService =util.getIdentityService() ;
		HistoryService historyService =util.getHistoryService() ;
		FormService formService = util.getFormService();
		
    }  
	
	@After  
    public void tearDown(){  
        System.out.println(" ----------------------- tearDown() -------------------");  
    }  
}
