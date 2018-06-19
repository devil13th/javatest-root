package com.thd.activiti.test01;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.ItemDefinition;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActivitiTest extends TestCase{
	
	
	
	/**
	 * 部署流程
	 * @throws Exception
	 */
	public void test01() throws Exception{
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
				.addClasspathResource("com/thd/activiti/test01/myProcess.bpmn20.xml")
				.deploy()
				.getId();
		System.out.println(deploymentId);
		System.out.println("success");
	}
	
	public void test01a() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"com/thd/activiti/activiti.cfg1.xml"});
		ProcessEngine processEngine = (ProcessEngine)context.getBean("processEngine");
		RuntimeService runtimeService = (RuntimeService)context.getBean("runtimeService");
		RepositoryService repositoryService = (RepositoryService)context.getBean("repositoryService");
		TaskService taskService = (TaskService)context.getBean("taskService");
		ManagementService managementService = (ManagementService)context.getBean("managementService");
		IdentityService identityService = (IdentityService)context.getBean("identityService");
		HistoryService historyService = (HistoryService)context.getBean("historyService");
		FormService formService = (FormService)context.getBean("formService");
		
		ProcessDefinition pd = repositoryService.getProcessDefinition("financialReport:1:3");
		System.out.println(pd.getName());
		
		BpmnModel m = repositoryService.getBpmnModel("financialReport:1:3");
		System.out.println(m);
		Map<String,ItemDefinition> itemMap = m.getItemDefinitions();
		
		Set keySet = itemMap.keySet();
		Iterator iter = keySet.iterator();
		while(iter.hasNext()){
			ItemDefinition def = itemMap.get(iter.next());
			System.out.println(def.getId());
			
		}
	}
	
	/**
	 * 启动流程
	 * @throws Exception
	 */
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
		
		
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("financialReport");
		System.out.println("已成功开启 financialReport 流程：" );
		
		System.out.println("ActivityId：" +processInstance.getActivityId());
		System.out.println("BusinessKey：" +processInstance.getBusinessKey());
		System.out.println("DeploymentId：" +processInstance.getDeploymentId());
		System.out.println("ID：" +processInstance.getId());
		System.out.println("NAME：" +processInstance.getName());
		
		/*
		 *
		功开启 financialReport 流程：
		ActivityId：writeReportTask
		BusinessKey：null
		DeploymentId：null
		ID：2501
		NAME：null
		 */
	
		
	}
	
	/**
	 * 创建用户和组
	 * @throws Exception
	 */
	public void test03() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"com/thd/activiti/activiti.cfg1.xml"});
		ProcessEngine processEngine = (ProcessEngine)context.getBean("processEngine");
		IdentityService identityService = (IdentityService)context.getBean("identityService");
		
		
		identityService.deleteUser("zhangsan");
		identityService.deleteUser("lisi");
		identityService.deleteUser("wangwu");
		identityService.deleteUser("zhaoliu");
		identityService.deleteGroup("accountancy");
		identityService.deleteGroup("management");
		//创建组
		Group gp = identityService.newGroup("accountancy");
		gp.setName("accountancy 1");
		
		
		//创建用户
		User u = identityService.newUser("zhangsan");
		u.setFirstName("zhang");
		u.setLastName("san");
		u.setEmail("zhangsan@ccs.org.cn");
		
		
		User u1 = identityService.newUser("wangwu");
		u1.setFirstName("wang");
		u1.setLastName("wu");
		u1.setEmail("wangwu@ccs.org.cn");
		//保存组
		identityService.saveGroup(gp);
		//保存用户
		identityService.saveUser(u);
		identityService.saveUser(u1);
		//建立用户加入到组的关系
		identityService.createMembership("zhangsan", "accountancy");
		identityService.createMembership("wangwu", "accountancy");
		
		
		Group gp2 = identityService.newGroup("management");
		gp2.setName("management 1");
		User u2 = identityService.newUser("lisi");
		u2.setFirstName("li");
		u2.setLastName("si");
		u2.setEmail("lisi@ccs.org.cn");
		
		User u3 = identityService.newUser("zhaoliu");
		u3.setFirstName("zhao");
		u3.setLastName("liu");
		u3.setEmail("zhaoliu@ccs.org.cn");
		identityService.saveGroup(gp2);
		identityService.saveUser(u2);
		identityService.saveUser(u3);
		identityService.createMembership("lisi", "management");
		identityService.createMembership("zhaoliu", "management");
		System.out.println("finish");
		
	}
	
	/**
	 * 获取组的待办
	 * @throws Exception
	 */
	public void test04() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"com/thd/activiti/activiti.cfg1.xml"});
		ProcessEngine processEngine = (ProcessEngine)context.getBean("processEngine");
		RuntimeService runtimeService = (RuntimeService)context.getBean("runtimeService");
		RepositoryService repositoryService = (RepositoryService)context.getBean("repositoryService");
		TaskService taskService = (TaskService)context.getBean("taskService");
		ManagementService managementService = (ManagementService)context.getBean("managementService");
		IdentityService identityService = (IdentityService)context.getBean("identityService");
		HistoryService historyService = (HistoryService)context.getBean("historyService");
		FormService formService = (FormService)context.getBean("formService");
		
		//通过组名称查询待办
		//List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("accountancy").list();
		List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("management").list();
		System.out.println("================ task list ==================");
		for(Task task : tasks){
			
			System.out.println("task.ExecutionId:" + task.getExecutionId());
			System.out.println("task.Description:" + task.getDescription());
			System.out.println("task.FormKey:" + task.getFormKey());
			System.out.println("task.Id:" + task.getId());
			System.out.println("task.Name:" + task.getName());
			System.out.println("task.Owner:" + task.getOwner());
			System.out.println("-------------------------------");
		}
		System.out.println("==================================");
		/**
		 * 
		    ================ task list ==================
			task.ExecutionId:2501
			task.Description:Write monthly financial report for publication to shareholders.
			task.FormKey:null
			task.Id:2504
			task.Name:Write monthly financial report
			task.Owner:null
			-------------------------------
			==================================
		 */
		
		//通过人员查询待办，因定义writeReportTask任务是由 accountancy 组中的人员完成，故该人必须是accountancy组的成员
		//List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("kermit").list();
	}
	
	
	/**
	 * 获取人的待办
	 * @throws Exception
	 */
	public void test05() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"com/thd/activiti/activiti.cfg1.xml"});
		ProcessEngine processEngine = (ProcessEngine)context.getBean("processEngine");
		RuntimeService runtimeService = (RuntimeService)context.getBean("runtimeService");
		RepositoryService repositoryService = (RepositoryService)context.getBean("repositoryService");
		TaskService taskService = (TaskService)context.getBean("taskService");
		ManagementService managementService = (ManagementService)context.getBean("managementService");
		IdentityService identityService = (IdentityService)context.getBean("identityService");
		HistoryService historyService = (HistoryService)context.getBean("historyService");
		FormService formService = (FormService)context.getBean("formService");
		
		
		//通过人员查询待办，因定义writeReportTask任务是由 accountancy 组中的人员完成，故该人必须是accountancy组的成员
		//List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("zhangsan").list();
		//List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("lisi").list();
		//List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("wangwu").list();
		List<Task> tasks = taskService.createTaskQuery().taskCandidateUser("zhaoliu").list();
		System.out.println("================ task list ==================");
		for(Task task : tasks){
			
			System.out.println("task.ExecutionId:" + task.getExecutionId());
			System.out.println("task.Description:" + task.getDescription());
			System.out.println("task.FormKey:" + task.getFormKey());
			System.out.println("task.Id:" + task.getId());
			System.out.println("task.Name:" + task.getName());
			System.out.println("task.Owner:" + task.getOwner());
			System.out.println("-------------------------------");
		}
		System.out.println("==================================");
		
		
		
		/**
		================ task list ==================
		task.ExecutionId:2501
		task.Description:Write monthly financial report for publication to shareholders.
		task.FormKey:null
		task.Id:2504
		task.Name:Write monthly financial report
		task.Owner:null
		-------------------------------
		==================================
		 */
	}
	
	/**
	 * 争抢任务并完成任务
	 * @throws Exception
	 */
	public void test06() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"com/thd/activiti/activiti.cfg1.xml"});
		ProcessEngine processEngine = (ProcessEngine)context.getBean("processEngine");
		RuntimeService runtimeService = (RuntimeService)context.getBean("runtimeService");
		RepositoryService repositoryService = (RepositoryService)context.getBean("repositoryService");
		TaskService taskService = (TaskService)context.getBean("taskService");
		ManagementService managementService = (ManagementService)context.getBean("managementService");
		IdentityService identityService = (IdentityService)context.getBean("identityService");
		HistoryService historyService = (HistoryService)context.getBean("historyService");
		FormService formService = (FormService)context.getBean("formService");
		
		String userId = "zhangsan";
		//String userId = "lisi";
		//String userId = "wangwu";
		//String userId = "zhaoliu";
		
		List<Task> tasks = taskService.createTaskQuery().taskCandidateUser(userId).list();
		//张三领取任务,领取任务后，改组中其他人员将看不到该待办
		taskService.claim(tasks.get(0).getId(), userId);
		//领取任务后任务会进入认领任务人的个人任务列表中
		List<Task> tasks2 = taskService.createTaskQuery().taskAssignee(userId).list();
		System.out.println("================ task list ==================");
		for(Task task : tasks2){
			System.out.println("task.ExecutionId:" + task.getExecutionId());
			System.out.println("task.Description:" + task.getDescription());
			System.out.println("task.FormKey:" + task.getFormKey());
			System.out.println("task.Id:" + task.getId());
			System.out.println("task.Name:" + task.getName());
			System.out.println("task.Owner:" + task.getOwner());
			System.out.println("-------------------------------");
		}
		System.out.println("==================================");
		//完成任务
		taskService.complete(tasks2.get(0).getId());
	}
	
	/**
	 * 查看任务到哪个步骤
	 * @throws Exception
	 */
	public void test07() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"com/thd/activiti/activiti.cfg1.xml"});
		ProcessEngine processEngine = (ProcessEngine)context.getBean("processEngine");
		RuntimeService runtimeService = (RuntimeService)context.getBean("runtimeService");
		RepositoryService repositoryService = (RepositoryService)context.getBean("repositoryService");
		TaskService taskService = (TaskService)context.getBean("taskService");
		ManagementService managementService = (ManagementService)context.getBean("managementService");
		IdentityService identityService = (IdentityService)context.getBean("identityService");
		HistoryService historyService = (HistoryService)context.getBean("historyService");
		FormService formService = (FormService)context.getBean("formService");
		
		//runtimeService.createProcessInstanceQuery().processInstanceId("1").
	}

	
}
