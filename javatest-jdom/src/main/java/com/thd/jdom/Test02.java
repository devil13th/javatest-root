/** 
 * Class Description:########
 * Date : 2016年11月16日 下午9:22:24
 * Auth : wanglei 
*/  

package com.thd.jdom;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;

public class Test02 {

	public static void main(String[] args) {
		try{
			InputStream is = Test02.class.getResourceAsStream("EPAS.bpmn");
			SAXBuilder builder = new SAXBuilder();   
			Document doc = builder.build(is);
			
			//命名空间
			Namespace ns = Namespace.getNamespace("http://www.omg.org/spec/BPMN/20100524/MODEL");
			
			//获取根节点
			Element root = doc.getRootElement();  
			System.out.println(root);
			System.out.println("-------------------------------");
			
			//获取根节点的所有子节点
			List<Element> els = root.getChildren();
			for(Element e : els){
				System.out.println(e);
			}
			System.out.println("-------------------------------");
			
			//获取process节点，注：一定要带着namespace!!
			Element process = root.getChild("process",ns);
			System.out.println(process);
			
			System.out.println("-------------------------------");
			
			
			Map<String,Element> userTasksMap = new HashMap<String,Element>();
			//获取用户任务节点
			List<Element> userTasks = process.getChildren("userTask",ns);
			for(Element e : userTasks){
				System.out.println(e.getName());
				System.out.println(e.getAttributeValue("id"));
				System.out.println(e.getAttributeValue("name"));
				System.out.println(e.getAttributeValue("candidateUsers",Namespace.getNamespace("http://activiti.org/bpmn")));
				
				userTasksMap.put(e.getAttributeValue("id"), e);
				
				/*List<Attribute> attrs = e.getAttributes();
				for(Attribute attr : attrs){
					System.out.println(attr);
				}*/
				System.out.println("**************************");
				
			}
			
			System.out.println("**************************");
			//获取开始节点
			Element startEvent = process.getChild("startEvent",ns);
		
			
			
			
			//获取连线
			List<Element> sequenceFlows = process.getChildren("sequenceFlow",ns);
			for(Element e : sequenceFlows){
				System.out.println(e.getName());
				System.out.println(e.getAttributeValue("id"));
				System.out.println(e.getAttributeValue("sourceRef"));
				System.out.println(e.getAttributeValue("targetRef"));
				System.out.println("**************************");
				
			}
            
			
			
			
            System.out.println("success");   

		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
