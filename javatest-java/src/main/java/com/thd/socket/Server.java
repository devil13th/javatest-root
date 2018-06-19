package com.thd.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket ss;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	public Server() throws Exception{
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(10000);

			while (true) {
				socket = ss.accept();
				in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				out = new PrintWriter(socket.getOutputStream(), true);

				String line = in.readLine();
				out.println("[server] accept you input is :" + line);
				System.out.println("[server print]you input is :" + line);
				out.close();
				in.close();
				socket.close();
				
				if(line.equals("end")){
					ss.close();
				}
			}
		} catch (IOException e) {
			if(ss != null){
				ss.close();
			}
		}
	}

	public static void main(String[] args) throws Exception{
		new Server();
	}

}
