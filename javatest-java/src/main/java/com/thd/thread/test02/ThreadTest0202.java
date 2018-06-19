package com.thd.thread.test02;

public class ThreadTest0202 {
	public static void main(String args[]) throws InterruptedException {
		String importantInfo[] = { "Mares eat oats", "Does eat oats",
				"Little lambs eat ivy", "A kid will eat ivy too" };

		for (int i = 0; i < importantInfo.length; i++) {
			// Pause for 4 seconds
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				return;
			}
			// Print a message
			System.out.println(importantInfo[i]);
		}
	}
}
