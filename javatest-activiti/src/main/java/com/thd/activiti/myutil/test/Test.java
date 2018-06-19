package com.thd.activiti.myutil.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.pvm.PvmActivity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import com.thd.activiti.ActivitiTestCase;

public class Test extends ActivitiTestCase{
	
	
	
	/**
	 * 部署流程
	 * @throws Exception
	 */
	public void test01deploy() throws Exception{
		Deployment deployment = this.util.deploy("com/thd/activiti/myutil/test/MyActivitiUtilTest.bpmn");
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
		String jobno = "2016CCSE002";
		
		String u1 = "u1";
		String u21 = "u21";
		String u22 = "u22";
		String u3 = "u3";
		String u4 = "u4";
		String u51 = "u51";
		String u52 = "u52";
		String u6 = "u6";
		String u71 = "u71";
		String u72 = "u72";
		String u73 = "u73";
		String u8 = "u8";
		String u91 = "u91";
		String u92 = "u92";
		String u10 = "u10";
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("u1", u1);
		map.put("u21", u21);
		map.put("u22", u22);
		map.put("u3", u3);
		map.put("u4", u4);
		map.put("u51", u51);
		map.put("u52", u52);
		map.put("u6", u6);
		map.put("u71", u71);
		map.put("u72", u72);
		map.put("u73", u73);
		map.put("u8", u8);
		map.put("u91", u91);
		map.put("u92", u92);
		map.put("u10", u10);
		
		map.put("type1","1");
		
//		map.put("type1","2");
//		map.put("type4","1");
//		map.put("type6","2");
		
		ProcessInstance processInstance = util.getRuntimeService().startProcessInstanceByKey("MyActivitiUtilTest",jobno,map);
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
		String u1 = "u1";
		String u21 = "u21";
		String u22 = "u22";
		String u3 = "u3";
		String u4 = "u4";
		String u51 = "u51";
		String u52 = "u52";
		String u6 = "u6";
		String u71 = "u71";
		String u72 = "u72";
		String u73 = "u73";
		String u8 = "u8";
		String u91 = "u91";
		String u92 = "u92";
		String u10 = "u10";
		util.claimAndComplateTask("2520", u1, null);
		//util.completeTask("122516", null);
	}
	
	public void test08addVarableToProcessInstance() throws Exception{
		Map map = new HashMap();
		map.put("type6","1");
		util.addVarableToProcessInstance(map, "122501");
	}
	
	
	/**
	 * 获取人的待办
	 * @throws Exception
	 */
	public void test03queryTask() throws Exception{
		String u1 = "u1";
		String u21 = "u21";
		String u22 = "u22";
		String u3 = "u3";
		String u4 = "u4";
		String u51 = "u51";
		String u52 = "u52";
		String u6 = "u6";
		String u71 = "u71";
		String u72 = "u72";
		String u73 = "u73";
		String u8 = "u8";
		String u91 = "u91";
		String u92 = "u92";
		String u10 = "u10";
		util.queryTaskForUser(u92);
	}
	
	
	public void test031ClaimTask() throws Exception{
		String u1 = "u1";
		String u21 = "u21";
		String u22 = "u22";
		String u3 = "u3";
		String u4 = "u4";
		String u51 = "u51";
		String u52 = "u52";
		String u6 = "u6";
		String u71 = "u71";
		String u72 = "u72";
		String u73 = "u73";
		String u8 = "u8";
		String u91 = "u91";
		String u92 = "u92";
		String u10 = "u10";
		util.claimTask("5007", u22);
	}
	
	public void test03UnClaimTask() throws Exception{
		String u1 = "u1";
		String u21 = "u21";
		String u22 = "u22";
		String u3 = "u3";
		String u4 = "u4";
		String u51 = "u51";
		String u52 = "u52";
		String u6 = "u6";
		String u71 = "u71";
		String u72 = "u72";
		String u73 = "u73";
		String u8 = "u8";
		String u91 = "u91";
		String u92 = "u92";
		String u10 = "u10";
		util.claimTask("5007", null);
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
	
	
	
	public void test06queryCurrentTask(){
		List<Task> tasks = util.queryCurrentTaskByBusinessKey("2016CCSE002");
		for(Task task : tasks){
			System.out.println(task.getName());
			System.out.println(task.getId());
		}
	}
	
	public void test09queryNextTaskByCurrentTaskId(){
		List<PvmActivity> r = util.queryNextTaskByCurrentTaskId("72507");
		for (PvmActivity ac : r) {
			System.out.println("下一步任务任务NAME：" + ac.getProperty("name"));
			System.out.println("下一步任务任务ID：" + ac.getId());
		}
	}
	
	public void test09queryPrevTaskByCurrentTaskId(){
		List<PvmActivity> r = util.queryPrevTaskByCurrentTaskId("72507");
		for (PvmActivity ac : r) {
			System.out.println("上一步任务任务NAME：" + ac.getProperty("name"));
			System.out.println("上一步任务任务ID：" + ac.getId());
		}
	}
	
	
	public void test08drawBpmn() throws Exception{
		util.drawBpmn("MyActivitiUtilTest:2:47504", "D://deleteme.jpg");
	}
	
	public void test09drawBpmnWithCurrentTask() throws Exception{
		util.drawBpmnWithCurrentTask("72507", "D://deleteme1.jpg");
	}
	
	public void test10jump(){
		util.jump("75001", "usertask1");
	}
	
	public void test11deleteDeploy(){
		util.deleteDeploy("1");
	}
	
	
	
	
}
