package com.thd.activiti.test02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.IdentityLinkType;

import com.thd.activiti.ActivitiTestCase;

public class Activiti2Test extends ActivitiTestCase{
	
	
	
	/**
	 * 部署流程
	 * @throws Exception
	 */
	public void test01() throws Exception{
		this.util.deploy("com/thd/activiti/test02/myProcess1.bpmn");
		System.out.println("success");
	}
	
	
	/**
	 * 启动流程
	 * @throws Exception
	 */
	public void test02beginProcess() throws Exception{
		
		//ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("qingjia");
		ProcessInstance processInstance = util.getRuntimeService().startProcessInstanceByKey("qingjia");
		System.out.println("已成功开启 qingjia 流程：" );
		System.out.println("ActivityId：" +processInstance.getActivityId());
		System.out.println("BusinessKey：" +processInstance.getBusinessKey());
		System.out.println("DeploymentId：" +processInstance.getDeploymentId());
		System.out.println("ID：" +processInstance.getId());
		System.out.println("NAME：" +processInstance.getName());
		
		
		/*
		 *
已成功开启 qingjia 流程：
ActivityId：qingjia-shenqing
BusinessKey：null
DeploymentId：null
ID：7501
NAME：null

		 */
	
		
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
		util.queryTaskForUser(user);
		/*
		
		
		List<Task> tasks = taskService.createTaskQuery().taskAssignee(user).list();
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
		*/
		/**
		================ task list ==================
		task.ExecutionId:7501
		task.Description:请假申请 提交
		task.FormKey:null
		task.Id:7504
		task.Name:请假申请
		task.Owner:null
		-------------------------------
		==================================
		
		
		
		================ task list ==================
		task.ExecutionId:7501
		task.Description:null
		task.FormKey:null
		task.Id:10003
		task.Name:正领导批假
		task.Owner:null
		-------------------------------
		==================================
		 */
	}
	
	/**
	 * 完成待办
	 * @throws Exception
	 */
	public void test04finishTask() throws Exception{
		//String user = "zhangsan";
		//String user = "lisi";
		//String user = "wangwu";
		
		
		Map m = new HashMap();
		m.put("type", "3");
		/*List<Task> tasks = taskService.createTaskQuery().taskAssignee(user).list();
		
		taskService.complete(tasks.get(0).getId(),m);
		System.out.println("finish");*/
		util.completeTask("80004", null);
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
		taskService.addUserIdentityLink("45003","zhaoliu", IdentityLinkType.OWNER);
		System.out.println("success");
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
