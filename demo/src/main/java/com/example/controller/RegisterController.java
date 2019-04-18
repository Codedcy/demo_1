package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bean.User;
import com.example.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public String registerPage() {
		return "register";
	}
		
	@RequestMapping("/registerpd")
	@ResponseBody
	public Map<String, Integer> registerpd(User user) {
		Map<String,Integer> map = new HashMap<String,Integer>();
 		if(userService.findByEmail(user.getEmail()) != null) {
			map.put("flag", 0);
		}else {
			userService.add(user);
			map.put("flag", 1);
		}
		return map;
	}
}
