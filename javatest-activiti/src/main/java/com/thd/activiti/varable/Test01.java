package com.thd.activiti.varable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import com.thd.activiti.ActivitiTestCase;

public class Test01 extends ActivitiTestCase{
	
	private String bk = "20171123-03";
	
	/**
	 * 部署流程
	 * @throws Exception
	 */
	public void test01deploy() throws Exception{
		Deployment deployment = this.util.deploy("com/thd/activiti/varable/test01.bpmn");
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
		
		String a = "a";
		String b = "b";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("a", a);
		map.put("b", b);
		
		ProcessInstance processInstance = util.getRuntimeService().startProcessInstanceByKey("var01",jobno,map);
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
		String a = "a";
		String b = "b";
		util.claimAndComplateTask("7508", a, null);
	}
	
	/**
	 * 设置流程变量
	 * Method Description : ########
	 */
	public void test04SetVarForExecution(){
		String executionId = "2501";
		util.getRuntimeService().setVariable(executionId, "name", "Zhang San");
	}
	/**
	 * 设置流程变量-local
	 * Method Description : ########
	 */
	public void test04SetVarLocalForExecution(){
		String executionId = "7503";
		util.getRuntimeService().setVariableLocal(executionId,"y", "y");
	}
	
	
	
	/**
	 * 设置流程变量
	 * Method Description : ########
	 */
	public void test05SetVarForTask(){
		String taskId = "10004";
		util.getTaskService().setVariable(taskId, "m", "m");
	}
	/**
	 * 设置流程变量-local
	 * Method Description : ########
	 */
	public void test05SetVarLocalForTask(){
		String executionId = "10004";
		util.getTaskService().setVariableLocal(executionId,"n", "n");
	}
	/**
	 * 查询流程变量
	 * Method Description : ########
	 */
	public void test05GetVarForExecution(){
		/*String executionId = "25001";
		String varName = "x";
		Object m = util.getRuntimeService().getVariable(executionId, varName);
		System.out.println(m);*/
		String executionId = "2501";
		Map m = util.getRuntimeService().getVariables(executionId);
		System.out.println(m);
		
	}
	
	/**
	 * 查询流程变量
	 * Method Description : ########
	 */
	public void test05GetVarForTask(){
		String taskId = "2501";
		String varName = "x";
		Object m = util.getTaskService().getVariable(taskId, varName);
		System.out.println(m);
	}
	
	/**
	 * 清除流程变量
	 * Method Description : ########
	 */
	public void test05DeleteVarForTask(){
		String taskId = "2506";
		Map<String,Object> varableMap = util.getTaskService().getVariables(taskId);
		Set mapKey = varableMap.keySet();
		Iterator iter = mapKey.iterator();
		while(iter.hasNext()){
			util.getTaskService().removeVariable(taskId, iter.next().toString());
		}
	}
	
	
	/**
	 * 查看流程变量
	 * Method Description : ########
	 */
	public void test05queryVarForProcessInstance(){
		
		//Map<String,Object> varableMap = util.getRuntimeService().createProcessInstanceQuery().processInstanceBusinessKey(bk).singleResult().getProcessVariables();
		
		ProcessInstance pi = util.getRuntimeService().createProcessInstanceQuery().processInstanceId("25001").singleResult();
		System.out.println(pi.getId());
		Map<String,Object> varableMap =pi.getProcessVariables();
		
		Set mapKey = varableMap.keySet();
		Iterator iter = mapKey.iterator();
		System.out.println(varableMap);
		while(iter.hasNext()){
			Object name = iter.next();
			Object v = varableMap.get(name);
			System.out.println(name+"|"+v);
		}
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
		String a = "a";
		String b = "b";
		util.queryTaskForUser(a);
	}
	
	
	/**
	 * 删除部署
	 */
	public void test04deletedeploy() throws Exception{
		String depId = "125001";
		util.deleteDeploy(depId);
	}
	
	/**
	 * 删除流程实例
	 */
	public void test05ProcessInstance()  throws Exception{
		util.cancelProcessInstance("2501", "");
	}
	
	/**
	 * 删除所有数据
	 */
	public void test06deleteAll()  throws Exception{
		String deploymentId = "1";
		util.deleteDeploy(deploymentId);
	}
	
	
}
