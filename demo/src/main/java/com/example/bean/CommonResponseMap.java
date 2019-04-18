package com.example.bean;

import java.util.HashMap;
import java.util.Map;

public class CommonResponseMap {
	private int resCode = -1;
	private String resMsg;
	private Map<String,String> resMap = new HashMap<String,String>();
	
	public int getResCode() {
		return resCode;
	}
	public void setResCode(int resCode) {
		this.resCode = resCode;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public Map<String, String> getResMap() {
		return resMap;
	}
	public void setResMap(Map<String, String> resMap) {
		this.resMap = resMap;
	}
	
	public void put(String string, String docUrl) {
		resMap.put(string, docUrl);
	}
	public void fail(int i, String string) {
		this.resCode = i;
		this.resMsg = string;
	}
	public void success() {
		this.resCode = 0;
		this.resMsg = "success!";
		
	}
	
}
