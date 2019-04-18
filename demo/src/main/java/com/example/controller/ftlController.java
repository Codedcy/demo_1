package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ftlController {
	@RequestMapping("/ftlIndex")
	public String ftl(Map<String,Object> m) {
		m.put("name","董春寅");
		m.put("age", 22);
		m.put("sex", 0);
		return "ftlIndex";
	}

}