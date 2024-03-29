package com.thd.activiti.test05;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Rule;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 该例子说明：
 * 并签
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
				.addClasspathResource("com/thd/activiti/test05/parallel.bpmn")
				.deploy()
				.getId();
		System.out.println(deploymentId);
		System.out.println("success");
	}
	
	
	/**
	 * 启动流程
	 * @throws Exception
	 */
	public void test02beginprocess() throws Exception{
		
		
		Map m = new HashMap();
		
		//设置执行顺序用户
		List<String> users = Arrays.asList("zhangsan","lisi","wangwu","zhaoliu");
		m.put("users",users);
		
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("parallelProcess",m);
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
		
		String[] users = new String[]{"zhangsan","lisi","wangwu","zhaoliu"};
		
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
	 * 张三完成待办
	 * @throws Exception
	 */
	public void test04finishtask() throws Exception{
		String user = "zhangsan";
//		String user = "lisi";
//		String user = "wangwu";
//		String user= "zhaoliu";
		List<Task> tasks = taskService.createTaskQuery().taskAssignee(user).list();
		Map m = new HashMap();
		m.put("type", "1");
		taskService.complete(tasks.get(0).getId(),m);
		System.out.println("finish");
	}
	
	public void test05() throws Exception{
		List<HistoricTaskInstance> l = historyService.createHistoricTaskInstanceQuery().finished().list();
		for(HistoricTaskInstance his : l){
			System.out.println("---------");
			System.out.println(his.getName());
			System.out.println(his.getId());
		}
		List<HistoricProcessInstance> l2 = 	historyService.createHistoricProcessInstanceQuery().finished().list();
		for(HistoricProcessInstance his : l2){
			System.out.println("---------");
			System.out.println(his.getName());
			System.out.println(his.getId());
		}
		
		
		
		InputStream processDiagram = repositoryService.getProcessDiagram("parallelProcess:1:60004");
		String homeDir = this.getClass().getResource("/").getFile();
		System.out.println(homeDir);
		InputStream processBpmn = this.repositoryService.getResourceAsStream("60001","dynamic-model.bpmn");
		System.out.println(processBpmn + "---");
		
		
		
	}
	
	
	
	
}
