package com.thd.runtime;

import org.junit.Test;

public class TestRuntime {
	@Test
	public void test01() {
		try{
			// 获得当前Runtime实例
			Runtime rt = Runtime.getRuntime();
			
			System.out.println("可用处理器个数：" + rt.availableProcessors());
			System.out.println("可用最大内存：" + rt.maxMemory());
			System.out.println("当前总内存：" + rt.totalMemory());
			System.out.println("空闲得内存：" + rt.freeMemory());
			System.out.println("-----------------------------");
			
			// 重点方法 运行命令行 （notepad.exe、calc.exe、某个可执行文件的路径）
			String command = "calc.exe"; // 打开计算器
			rt.exec(command);
			// 打开QQ 请改成自己QQ的路径
			command = "C:\\Program Files (x86)\\Tencent\\QQ\\Bin\\QQ.exe";
			rt.exec(command);

			// 和System类似的方法，实际上System中调用的就是Runtime对应的方法
			rt.runFinalization(); // 运行finalize方法。
			rt.gc(); // 运行垃圾回收器（官方解释） 实际上这种运行可能只是建议性运行
			rt.exit(0); // 参数 如果是非0代表异常终止，多放在捕获异常的catch块中
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
