package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class IndexController {
//	@RequestMapping("/index")
//	@ResponseBody
//	public Map<String,Object> index(int i){
//		int j =1/i;
//		Map<String,Object> m = new HashMap<String,Object>();
//		m.put("errerCode", 200);
//		m.put("errorMsg", "错误码");
//		m.put("j", j);
//		return m;
//	}
	
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/indextest")
	public String indextest() {
		return "index";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
//	@RequestMapping("/login")
//	public String login() {
//		return "login";
//	}
	
}
