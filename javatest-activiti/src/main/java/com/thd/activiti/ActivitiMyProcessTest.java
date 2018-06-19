package com.thd.activiti;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import junit.framework.TestCase;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActivitiMyProcessTest extends TestCase{
	public void test01() throws Exception{
		//定义数据源配置文件
		File cfgXML = new File("E://thdsvn//java_project//activiti//src//main//java//com//thd//activiti//activiti.cfg.xml");
		System.out.println(cfgXML);
		InputStream ins = new FileInputStream(cfgXML.getAbsolutePath());
		//创建流程引擎对象
		ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromInputStream(ins).buildProcessEngine();
		System.out.println(processEngine);
		//ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		//获取流程引擎所需的Service
		RepositoryService repositoryService = processEngine.getRepositoryService();
		TaskService taskService = processEngine.getTaskService();
		ManagementService managementService = processEngine.getManagementService();
		IdentityService identityService = processEngine.getIdentityService();
		HistoryService historyService = processEngine.getHistoryService();
		FormService formService = processEngine.getFormService();
		System.out.println("success");
		//Deployment deployment = repositoryService.createDeployment().addClasspathResource("com/thd/activity/FinancialReportProcess.bpmn20.xml").deploy();
	}
	public void test02() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"com/thd/activiti/activiti.cfg1.xml"});
		ProcessEngine processEngine = (ProcessEngine)context.getBean("processEngine");
		System.out.println(processEngine);
		
		RuntimeService runtimeService = (RuntimeService)context.getBean("runtimeService");
		System.out.println(runtimeService);
		
		RepositoryService repositoryService = (RepositoryService)context.getBean("repositoryService");
		System.out.println(repositoryService);
		TaskService taskService = (TaskService)context.getBean("taskService");
		System.out.println(taskService);
		ManagementService managementService = (ManagementService)context.getBean("managementService");
		System.out.println(managementService);
		IdentityService identityService = (IdentityService)context.getBean("identityService");
		System.out.println(identityService);
		HistoryService historyService = (HistoryService)context.getBean("historyService");
		System.out.println(historyService);
		FormService formService = (FormService)context.getBean("formService");
		System.out.println(formService);
		
		
		System.out.println("success");
	}
	
	public void test03() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"com/thd/activiti/activiti.cfg1.xml"});
		ProcessEngine processEngine = (ProcessEngine)context.getBean("processEngine");
		System.out.println(processEngine);
		RuntimeService runtimeService = (RuntimeService)context.getBean("runtimeService");
		System.out.println(runtimeService);
		RepositoryService repositoryService = (RepositoryService)context.getBean("repositoryService");
		System.out.println(repositoryService);
		TaskService taskService = (TaskService)context.getBean("taskService");
		System.out.println(taskService);
		ManagementService managementService = (ManagementService)context.getBean("managementService");
		System.out.println(managementService);
		IdentityService identityService = (IdentityService)context.getBean("identityService");
		System.out.println(identityService);
		HistoryService historyService = (HistoryService)context.getBean("historyService");
		System.out.println(historyService);
		FormService formService = (FormService)context.getBean("formService");
		System.out.println(formService);
		
		String deploymentId = repositoryService
				.createDeployment()
				.addClasspathResource("com/thd/activiti/myProcess.bpmn20.xml")
				.deploy()
				.getId();
		System.out.println(deploymentId);
		System.out.println("success");
	}
}
