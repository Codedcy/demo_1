package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bean.Comment;
import com.example.service.CommentService;
import com.example.service.RouteService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	@Autowired
	private RouteService routeService;
	
	@RequestMapping("/commentList")
	public String commentList(Model model) {
		int page=1;
		int count = 8;
		int start = (page-1)*count;
		int totalPages = (int) Math.ceil(commentService.getCounts()/(double)count);
		model.addAttribute("commentList", commentService.queryAllCommentsPager(start, count));
		model.addAttribute("graList", routeService.getGra());
		model.addAttribute("totalPages", totalPages);
		return "commentList";
	}
	
	@RequestMapping("/commentListAjax")
	@ResponseBody
	public Map<String,Object> commentListAjax(int page) {
		int count = 8;
		int start = (page-1)*count;
		int totalPages = (int) Math.ceil(commentService.getCounts()/(double)count);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("commentList", commentService.queryAllCommentsPager(start, count));
		map.put("totalPages", totalPages);
		return map;
	}
	
	@RequestMapping("/commentListByUserId")
	public String commentListByUserId(Model model,int userId) {
		model.addAttribute("commentList", commentService.queryCommentsByUserId(userId));
		return "commentListByUserId";
	}
	
	@RequestMapping("/commentListByGraId")
	@ResponseBody
	public Map<String,Object> commentListByGraId(int graId, int page) {
		int count = 8;
		int start = (page-1)*count;
		int totalPages = (int) Math.ceil(commentService.getCountsByGraId(graId)/(double)count);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("commentList", commentService.queryCommentsByGraId(graId,start,count));
		map.put("totalPages", totalPages);
		return map;
	}
	
	@RequestMapping("/commentListByGraIdAndUserId")
	public String commentListByGraIdAndUserId(Model model, int graId, int userId) {
		model.addAttribute("commentList", commentService.queryCommentsByGraIdAndUserId(graId, userId));
		return "commentListByGraIdAndUserId";
	}
	
	@RequestMapping("/addComment")
	@ResponseBody
	public Map<String,Object> addComment(Comment comment,int graId) {
		
		commentService.addComment(comment);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("status", 1);
		return map;
	}
	
}
