package com.example;

import io.goeasy.GoEasy;

public class ChannelTest {
	GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io", "BC-9c088edbd6ca4ca6b34e2d20033f727d");
	public void testChannel(int i) {
	    goEasy.publish("demo_channel", i+"");
	}
	
	public static void main(String args[]) throws InterruptedException {
		int i = 100;
		ChannelTest c = new ChannelTest();
		while(i-->0) {
			c.testChannel(i);
			Thread.sleep(1000);
			System.out.println(i);
		}
	}
	
}
