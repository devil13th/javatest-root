package com.thd.activiti.gateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import com.thd.activiti.ActivitiTestCase;

public class Test01 extends ActivitiTestCase{
	
	private String bk = "20171123-01";
	
	/**
	 * 部署流程
	 * @throws Exception
	 */
	public void test01deploy() throws Exception{
		Deployment deployment = this.util.deploy("com/thd/activiti/gateway/test01.bpmn");
		System.out.println("deployment id:" + deployment.getId());
		System.out.println("success");
	}
	
	/**
	 * 删除已部署的流程
	 * @throws Exception
	 */
	public void test01deletedeploy() throws Exception{
		this.util.deleteDeploy("120001");
		System.out.println("success");
	}
	
	/**
	 * 启动流程
	 * @throws Exception
	 */
	public void test02beginProcess() throws Exception{
		String jobno = bk;
		
		String t1 = "t1";
		String t2 = "t2";
		String t3 = "t3";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("t1", t1);
		map.put("t2", t2);
		map.put("t3", t3);
		
		ProcessInstance processInstance = util.getRuntimeService().startProcessInstanceByKey("gatewaytest01",jobno,map);
		System.out.println("已成功开启流程：" );
		System.out.println("ActivityId：" +processInstance.getActivityId());
		System.out.println("BusinessKey：" +processInstance.getBusinessKey());
		System.out.println("DeploymentId：" +processInstance.getDeploymentId());
		System.out.println("ID：" +processInstance.getId());
		System.out.println("NAME：" +processInstance.getName());
	}
	
	/**
	 * 完成待办
	 * @throws Exception
	 */
	public void test03completeTask() throws Exception{
		String t1 = "t1";
		String t2 = "t2";
		String t3 = "t3";
		util.claimAndComplateTask("27503", t3, null);
	}
	
	
	public void test06queryCurrentTask(){
		List<Task> tasks = util.queryCurrentTaskByBusinessKey(bk);
		for(Task task : tasks){
			System.out.println(task.getName());
			System.out.println(task.getId());
		}
	}
	
	/**
	 * 获取人的待办
	 * @throws Exception
	 */
	public void test03queryTask() throws Exception{
		String t1 = "t1";
		String t2 = "t2";
		String t3 = "t3";
		util.queryTaskForUser(t2);
	}
	
	
	/**
	 * 删除部署
	 */
	public void test04deletedeploy() throws Exception{
		String depId = "125001";
		util.deleteDeploy(depId);
	}
	
	/**
	 * 删除流程实力
	 */
	public void test05ProcessInstance()  throws Exception{
		util.cancelProcessInstance("2501", "");
	}
	
	
}
