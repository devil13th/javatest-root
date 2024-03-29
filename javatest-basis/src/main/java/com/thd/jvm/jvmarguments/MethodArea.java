package com.thd.jvm.jvmarguments;

import java.util.ArrayList;
import java.util.List;

public class MethodArea {
	/*
	 * VM Args: -XX:PermSize=10m -XX:MaxPermSize=10m
	 * 
	 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
	 */
	public static void main(String[] args) {
		 // 使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }

	}

}
