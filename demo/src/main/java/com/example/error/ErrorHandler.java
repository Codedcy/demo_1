package com.example.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice(basePackages = "com.example.controller")
public class ErrorHandler {
//	@ExceptionHandler(RuntimeException.class)
//	@ResponseBody
//	public Map<String,Object> errorRes() {
//		Map<String,Object> m = new HashMap<String,Object>();
//		m.put("errorCode", 500);
//		m.put("errorMsg", "SystemError");
//		return m;
//	}
}
