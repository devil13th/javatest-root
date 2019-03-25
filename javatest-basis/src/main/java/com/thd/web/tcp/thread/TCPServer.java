package com.thd.web.tcp.thread;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {

	public static void main(String[] args) throws Exception {
	        @SuppressWarnings("resource")
	        ServerSocket ss = new ServerSocket(8090);
	        System.out.println("TCP server ready.");
	        for (;;) {  // 无限for循环中返回客户端新建的连接
	            Socket sock = ss.accept();
	            // 设置线程要处理的任务
	            Runnable handler = new TimeHandler(sock);
	            // 使用Java提供的ExecutorService创建线程池
	            ExecutorService executor = Executors.newCachedThreadPool();
	            // 线程处理任务
	            executor.submit(handler);
	            // 任务处理完毕，关闭线程
	            executor.shutdown();
	        }

	}

}
