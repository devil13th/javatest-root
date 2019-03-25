package com.thd.web.tcp.simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPClient {
	public static void main(String[] args) throws Exception{
		// 获取本机地址，即“127.0.0.1”
        InetAddress addr = InetAddress.getLoopbackAddress(); 
        // 与本机8090端口建立连接
        try (Socket sock = new Socket(addr, 8090)) {
        // 将读写字节流包装成BufferedReader和BufferedWriter对象
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(sock.getInputStream(), StandardCharsets.UTF_8))) {
                try (BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(sock.getOutputStream(), StandardCharsets.UTF_8))) {
                    // 写入“time”字符串
                    writer.write("time\n");
                    // 将写入内存缓冲区的数据立即发送
                    writer.flush();
                    // 读取本机8090端口返回的数据
                    String resp = reader.readLine();
                    System.out.println("Response: " + resp);
                }
            }
        }
	}
}
