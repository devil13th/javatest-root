package com.thd.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	static Socket server;

	public static void main(String[] args) throws Exception {
		server = new Socket("127.0.0.1", 10000);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				server.getInputStream()));
		PrintWriter out = new PrintWriter(server.getOutputStream());
		BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = wt.readLine();
			out.println(str);
			System.out.println("[client:]" + str);
			out.flush();
			if (str.equals("end")) {
				break;
			}
			System.out.println(in.readLine());
		}
		server.close();
	}

}
