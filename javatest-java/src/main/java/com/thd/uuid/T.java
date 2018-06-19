package com.thd.uuid;

import java.util.UUID;

public class T {
	public static void main(String[] args) {
		UUID id = UUID.randomUUID();
		String ids = id.toString().trim().replace("-", "");
		System.out.println(id);
		System.out.println(ids);
		System.out.println(ids.length());
	}
}
