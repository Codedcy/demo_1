package com.example.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bean.User;
import com.example.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userService;
	
	
	/*
	 * 登陆判断：返回1->登陆成功
	 * 		     返回0->登陆失败
	 * */
	@RequestMapping("")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/loginpd")
	@ResponseBody
	public Map<String,Integer> loginpd(String email, String passWord,HttpServletRequest request, HttpServletResponse response) {
		System.out.println(email);
		Map<String,Integer> map = new HashMap<String,Integer>();
		User user = userService.findByEmail(email);
		if(user != null && user.getPassWord().equals(passWord)) {
			map.put("flag", 1);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		}else {
			map.put("flag", 0);
		}
		return map;
	}
	
	@RequestMapping("/logintz/{email}")
	public String logintz(HttpServletRequest request, HttpServletResponse response, @PathVariable String email ) {
		User user = userService.findByEmail(email);
		HttpSession session = request.getSession();
		session.setAttribute("email", user.getEmail());
		session.setAttribute("userName", user.getUserName());
		session.setAttribute("sex", user.getSex());
		session.setAttribute("user", user);
		
		return "index";
	}
	
}
