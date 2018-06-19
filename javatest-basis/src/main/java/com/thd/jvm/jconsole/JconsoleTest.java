/** 
 * Class Description:########
 * Date : 2018年4月10日 上午10:51:26
 * Auth : ccse 
*/  

package com.thd.jvm.jconsole;

import java.util.ArrayList;
import java.util.List;

public class JconsoleTest {
	
	public byte[] b1 = new byte[128 * 1024];
	
	public static void main(String[] args){
		try   {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Start...");
		fill(1000);
		
	}
	private static void fill(int n){
		List<JconsoleTest> jlist = new ArrayList<JconsoleTest>();
		for(int i = 0 ; i < n ; i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
			jlist.add(new JconsoleTest());
		}
	}
}
