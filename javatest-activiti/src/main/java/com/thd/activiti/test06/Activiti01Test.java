package com.thd.activiti.test06;

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
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.apache.commons.io.FileUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.thd.activiti.myutil.MyActivitiUtil;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

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
	private MyActivitiUtil util = new MyActivitiUtil("com/thd/activiti/activiti.cfg1.xml");
	
	/**
	 * 部署流程
	 * @throws Exception
	 */
	public void test01deployprocess() throws Exception{
		String deploymentId = repositoryService
				.createDeployment()
				.addClasspathResource("com/thd/activiti/test06/draw.bpmn")
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
		List<String> users = Arrays.asList("zhangsan","lisi","wangwu","zhaoliu");
		m.put("users",users);
		
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("draw",m);
		System.out.println("已成功开启 serialProcess 流程：" );
		System.out.println("ActivityId：" +processInstance.getActivityId());
		System.out.println("BusinessKey：" +processInstance.getBusinessKey());
		System.out.println("DeploymentId：" +processInstance.getDeploymentId());
		System.out.println("ID：" +processInstance.getId());
		System.out.println("NAME：" +processInstance.getName());
	}
	
	
	
	
	public void test03drawimages() throws Exception{
//		repositoryService.getProcessDiagram(arg0);
		//processDefinition.getDiagramResourceName();
		
		ProcessDefinition processDefinition = repositoryService.getProcessDefinition("draw:2:57504");
		System.out.println(processDefinition.getDiagramResourceName());
		InputStream imageStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), processDefinition.getDiagramResourceName());
        File f = new File("D://aa.png");
        FileUtils.copyInputStreamToFile(imageStream, f);
        
        
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("com/thd/activiti/test06/draw.bpmn");    //获取xml文件流  
        System.out.println(is);
        XMLInputFactory xmlFactory  = XMLInputFactory.newInstance();
        XMLStreamReader reader = xmlFactory.createXMLStreamReader(is);
        BpmnModel bpmnModel = new BpmnXMLConverter().convertToBpmnModel(reader);
        ProcessDiagramGenerator pdg = new DefaultProcessDiagramGenerator();
        System.out.println(runtimeService.getActiveActivityIds("60001"));
        InputStream img = pdg.generateDiagram(bpmnModel, "png",  runtimeService.getActiveActivityIds("60001"), new ArrayList<String>());
        System.out.println(img);
        File f1 = new File("D://ab.png");
        FileUtils.copyInputStreamToFile(img, f1);
       }
	
	
	
	
}
