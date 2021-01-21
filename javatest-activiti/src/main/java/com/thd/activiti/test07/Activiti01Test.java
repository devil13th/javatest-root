package com.thd.activiti.test07;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.IdentityLinkType;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.apache.commons.io.FileUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 该例子说明：
 * 从流程变量中获取代办人的例子
 */
public class Activiti01Test extends TestCase{
	private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"com/thd/activiti/activiti.cfg1.xml"});
	private ProcessEngine processEngine = (ProcessEngine)context.getBean("processEngine");
	private RuntimeService runtimeService = (RuntimeService)context.getBean("runtimeService");
	private RepositoryService repositoryService = (RepositoryService)context.getBean("repositoryService");
	private TaskService taskService = (TaskService)context.getBean("taskService");
	private ManagementService managementService = (ManagementService)context.getBean("managementService");
	private IdentityService identityService = (IdentityService)context.getBean("identityService");
	private HistoryService historyService = (HistoryService)context.getBean("historyService");
	private FormService formService = (FormService)context.getBean("formService");
	
	/**
	 * 部署流程
	 * @throws Exception
	 */
	public void test01deployprocess() throws Exception{
		String deploymentId = repositoryService
				.createDeployment()
				.addClasspathResource("com/thd/activiti/test07/assignPerson.bpmn")
				.deploy()
				.getId();
		System.out.println(deploymentId);
		System.out.println("success");
	}
	
	/**
	 * 创建流程实例
	 * @throws Exception
	 */
	public void test02beginprocess() throws Exception{
		Map m = new HashMap();
		
		//设置执行顺序用户
		List<String> users = Arrays.asList("wangwu","zhaoliu");
		
		//设置代办人
		m.put("apply","zhangsan");
		m.put("audit","lisi");
		m.put("destory","zhangsan");
		m.put("file",users);
				
				
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacation",m);
		System.out.println("已成功开启 serialProcess 流程：" );
		System.out.println("ActivityId：" +processInstance.getActivityId());
		System.out.println("BusinessKey：" +processInstance.getBusinessKey());
		System.out.println("DeploymentId：" +processInstance.getDeploymentId());
		System.out.println("ID：" +processInstance.getId());
		System.out.println("NAME：" +processInstance.getName());
	}
	
	
	
	/**
	 * 获取人的待办
	 * @throws Exception
	 */
	public void test03findtask() throws Exception{
		
		String[] users = new String[]{"zhangsan","lisi","wangwu","zhaoliu","sunqi"};
		
		for(String user : users){
		
			List<Task> tasks = taskService.createTaskQuery().taskAssignee(user).list();
			System.out.println("================ [" + user + "]task list ==================");
			for(Task task : tasks){
				
				System.out.println("task.ExecutionId:" + task.getExecutionId());
				System.out.println("task.Description:" + task.getDescription());
				System.out.println("task.FormKey:" + task.getFormKey());
				System.out.println("task.Id:" + task.getId());
				System.out.println("task.Name:" + task.getName());
				System.out.println("task.Owner:" + task.getOwner());
				System.out.println("-------------------------------");
			}
			System.out.println("==============================================================");
		}
		
	}
	
	
	
	/**
	 * 完成待办
	 * @throws Exception
	 */
	public void test04finishtask() throws Exception{
		String user = "zhangsan";
		//String user = "lisi";
		//String user = "wangwu";
		//String user= "zhaoliu";
		List<Task> tasks = taskService.createTaskQuery().taskAssignee(user).list();
		Map m = new HashMap();
		m.put("type", "1");
		taskService.complete(tasks.get(0).getId(),m);
		System.out.println("finish");
	}
	
	
	public void test06() throws Exception{
		//某代办交给其他人办理（自己仍存在待办）
		//taskService.delegateTask("45003", "zhaoliu");
		//System.out.println("success");
		
		//将某任务的待办人更换为zhaoliu
		//taskService.addUserIdentityLink("10002","sunqi", IdentityLinkType.OWNER);
		//taskService.addUserIdentityLink("10002","sunqi", IdentityLinkType.PARTICIPANT);
		taskService.addUserIdentityLink("32502","sunqi", IdentityLinkType.ASSIGNEE);
		//taskService.addUserIdentityLink("32502","sunqi", IdentityLinkType.CANDIDATE);
		
		System.out.println("success");
	}
	
	
	
	
	
}
