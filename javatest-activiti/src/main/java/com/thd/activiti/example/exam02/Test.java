package com.thd.activiti.example.exam02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import com.thd.activiti.ActivitiTestCase;

public class Test extends ActivitiTestCase{
	
	
	
	/**
	 * 部署流程
	 * @throws Exception
	 */
	public void test01deploy() throws Exception{
		this.util.deploy("com/thd/activiti/example/exam02/EPAS.bpmn");
		System.out.println("success");
	}
	
	
	/**
	 * 启动流程
	 * @throws Exception
	 */
	public void test02beginProcess() throws Exception{
		String jobno = "2014DL350003";
		
		String applyUser = "apply_user";
		String drawUser = "draw_user1,draw_user2";
		String auditUser = "audit_user";
		String fileUser = "file_user";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("apply", applyUser);
		map.put("draw", drawUser);
		map.put("audit", auditUser);
		map.put("file", fileUser);
		
		ProcessInstance processInstance = util.getRuntimeService().startProcessInstanceByKey("EPASProcess",jobno,map);
		System.out.println("已成功开启  流程：" );
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
	public void test03queryTask() throws Exception{
		String applyUser = "apply_user";
		String reviewUser = "review_user";
		String drawUser1 = "draw_user1";
		String drawUser2 = "draw_user2";
		String auditUser = "audit_user";
		String printUser = "print_user";
		String fileUser = "file_user";
		util.queryTaskForUser(applyUser);
	}
	
	/**
	 * 完成待办
	 * @throws Exception
	 */
	public void test04completeTask() throws Exception{
		String applyUser = "apply_user";
		String reviewUser = "review_user";
		String drawUser1 = "draw_user1";
		String drawUser2 = "draw_user2";
		String auditUser = "audit_user";
		String printUser = "print_user";
		String fileUser = "file_user";
		util.claimAndComplateTask("95003", fileUser, null);
	}
	
	public void test04assignUser() throws Exception{
		//String user = "zhangsan";
		String user = "lisi";
		//String user = "wangwu";
		//String user = "zhaoliu";
		String taskId = "77504";
		util.getTaskService().addCandidateUser(taskId, "zhangsan");
		util.getTaskService().addCandidateUser(taskId, "lisi");
		util.getTaskService().addCandidateUser(taskId, "wangwu");
		System.out.println("success");
	}
	
	public void test05GetAllElement(){
		util.getAllElement("EPASProcess:1:27504");
	}
	
	public void test06QueryCurrentStep(){
		List<Execution> executionList = util.queryCurrentExecutes("100001");
		for(Execution exe : executionList){
			System.out.println(exe.getId() + "|" + exe.getName() + "|" + exe.getClass());
			
		}
	}
	
	public void test07QueryCurrentStep(){
		List<Task> taskList = util.queryCurrentTaskByBusinessKey("2014DL350001");
		for(Task task : taskList){
			System.out.println(task.getId() + "|" + task.getName()  + "|" + task.getClass());
			
		}
		
	}
	
	
	
	
	
}
