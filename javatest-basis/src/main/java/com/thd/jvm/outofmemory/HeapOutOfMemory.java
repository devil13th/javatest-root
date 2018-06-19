/** 
 * Class Description:########
 * Date : 2018年4月3日 下午3:43:26
 * Auth : ccse 
*/  

package com.thd.jvm.outofmemory;
import java.util.ArrayList;
public class HeapOutOfMemory {
	
	/**
	 * 运行前设置jvm参数：-Xms5m -Xmx5m -XX:PermSize=5M -XX:MaxPermSize=5M -XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=d:/a.txt
	 * 以上参数在eclipse 中的  run configurations菜单中设置(目录中右键此类Run As ->  run configurations)
	 */
	public static void main(String[] args){
		ArrayList list=new ArrayList();
		int i = 0;
		while(true){
			System.out.println(i++);
		    list.add(new HeapOutOfMemory());
		}
	}
}
