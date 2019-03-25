package com.thd.web.tcp.simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class TCPServer {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		 // 监听8090端口
        ServerSocket ss = new ServerSocket(8090);
        System.out.println("TCP server ready.");
        // 建立连接
        Socket sock = ss.accept();
        // 包装读写字节流
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(sock.getInputStream(), StandardCharsets.UTF_8))) {
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(sock.getOutputStream(), StandardCharsets.UTF_8))) {
                // 读取发送到服务端的数据	
                String cmd = reader.readLine();
                // 如果数据是“time”字符串则将当前时间信息返回客户端
                if ("time".equals(cmd)) {
                    writer.write(LocalDateTime.now().toString() + "\n");
                    // 将写入内存缓冲区的数据立即发送
                    writer.flush();
                } else {
                    writer.write("require data\n");
                    writer.flush();
                }
            }
        }
        // 关闭连接
        sock.close();
        // 关闭监听端口
        ss.close();
	}

}
