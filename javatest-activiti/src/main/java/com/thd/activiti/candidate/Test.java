package com.thd.activiti.candidate;

import java.util.List;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.IdentityLinkType;
import org.activiti.engine.task.Task;

import com.thd.activiti.ActivitiTestCase;

public class Test extends ActivitiTestCase{
	
	
	
	/**
	 * 部署流程
	 * @throws Exception
	 */
	public void test01deploy() throws Exception{
		this.util.deploy("com/thd/activiti/candidate/candidate.bpmn");
		System.out.println("success");
	}
	
	
	/**
	 * 启动流程
	 * @throws Exception
	 */
	public void test02beginProcess() throws Exception{
		
		ProcessInstance processInstance = util.getRuntimeService().startProcessInstanceByKey("vacat","myTest001");
		System.out.println("已成功开启 qingjia 流程：" );
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
	public void test03findTask() throws Exception{
		//String user = "zhangsan";
		String user = "lisi";
		//String user = "wangwu";
		//String user = "zhaoliu";
		util.queryTaskForUser("zhangsan");
	}
	public void test04assignUser() throws Exception{
		//String user = "zhangsan";
		String user = "lisi";
		//String user = "wangwu";
		//String user = "zhaoliu";
		String taskId = "2504";
		util.getTaskService().addCandidateUser(taskId, "zhangsan");
		util.getTaskService().addCandidateUser(taskId, "lisi");
		util.getTaskService().addCandidateUser(taskId, "wangwu");
		System.out.println("success");
	}
	
	/**
	 * 完成待办
	 * @throws Exception
	 */
	public void test04finishTask() throws Exception{
		//String user = "zhangsan";
		//String user = "lisi";
		String user = "zhangsan";
		
		util.completeTask("77504",null);
	}
	
	
	public void test05suspendsProcessInstance() throws Exception{
		util.suspendsProcessInstance("2501");
		System.out.println("success");
	}
	
	public void test06activateProcessInstance() throws Exception{
		util.activateProcessInstance("2501");
		System.out.println("success");
	}
	
	public void test07cancelProcessInstance() throws Exception{
		util.cancelProcessInstance("2501", "测试作废");
		System.out.println("success");
	}
	
	public void test100todo() throws Exception{
		util.getTaskService().addCandidateUser("55004", "lisi");
		System.out.println("success");
	}
	public void test99queryTaskOfProcessInstance() throws Exception{
		List<Task> tasks = util.getTaskService().createTaskQuery().processInstanceId("2501").list();
		
		for(Task task : tasks){
			System.out.println(task.getId());
			System.out.println(task.getName());
		}
		System.out.println("success");
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
		
	}
	
	
	public void test06() throws Exception{
		//某代办交给其他人办理（自己仍存在待办）
		//taskService.delegateTask("45003", "zhaoliu");
		//System.out.println("success");
		
		//将某任务的待办人更换为zhaoliu
		//taskService.addUserIdentityLink("45003","zhaoliu", IdentityLinkType.OWNER);
		//System.out.println("success");
		
		
		List l = util.getTaskService().createTaskQuery().processInstanceId("67501").list();
		
		
		
		System.out.println(l);
	}
	
	/**
	 * 流程变量相关操作
	 * Method Description : ########
	 * @throws Exception
	 */
	public void test07() throws Exception{
//		runtimeService.setVariable("2501", "a", "1");
//		taskService.setVariable("2504", "b", "2");
//		runtimeService.setVariableLocal("2501", "c", "3");
//		taskService.setVariableLocal("2504", "d", "4"); //流程变量绑定 任务ID
		
//		System.out.println(runtimeService.getVariable("2501", "c"));
//		System.out.println(taskService.getVariable("2504", "b"));
//		System.out.println(runtimeService.getVariableLocal("2501", "c"));
//		System.out.println(taskService.getVariableLocal("2504", "d"));
		
		//util.suspendsProcessInstance("37501");
		//util.activateProcessInstance("37501");
		//util.getTaskService().
		
		
		List l = util.getHistoryService().createHistoricProcessInstanceQuery().finished().list();
		System.out.println(l);
		System.out.println("success");
	}
	
	
}
