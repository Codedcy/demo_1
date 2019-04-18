package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Comment;
import com.example.mapper.CommentMapper;
import com.example.mapper.RouteMapper;
import com.example.mapper.UserMapper;

@Service
public class CommentService {
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RouteMapper routeMapper;
	
	public int getCounts() {
		return commentMapper.getCounts();
	}
	
	public int getCountsByGraId(int graId) {
		return commentMapper.getCountsByGraId(graId);
	}
	
	public List<Comment> queryAllComments(){
		List<Comment> commentList = commentMapper.queryAllComments();
		for (Comment comment : commentList) {
			comment.setUser(userMapper.getById(comment.getUserId()).get(0));
		}
		return commentList;
	}
	
	public List<Comment> queryAllCommentsPager(int start, int count){
		List<Comment> commentList = commentMapper.queryAllCommentsPager(start, count);
		for (Comment comment : commentList) {
			comment.setUser(userMapper.getById(comment.getUserId()).get(0));
			comment.setGra(routeMapper.getGraByGraId(comment.getGraId()));
		}
		return commentList;
	}
	
	public int addComment(Comment comment) {
		return commentMapper.addComment(comment);
	}
	
	public List<Integer> getGraIdByUserId(int userId){
		List<Integer> graIdList = commentMapper.getGraIdByUserId(userId);
		return graIdList;
	}
	
	public List<Comment> queryCommentsByUserId(int userId ){
		List<Comment> commentList = commentMapper.queryCommentsByUserId(userId);
		for (Comment comment : commentList) {
			comment.setUser(userMapper.getById(comment.getUserId()).get(0));
		}
		return commentList;
	}
	
	public List<Comment> queryCommentsByGraId(int graId,int start, int count){
		List<Comment> commentList = commentMapper.queryCommentsByGraId(graId, start, count);
		for (Comment comment : commentList) {
			comment.setUser(userMapper.getById(comment.getUserId()).get(0));
			comment.setGra(routeMapper.getGraByGraId(comment.getGraId()));
		}
		return commentList;
	}
	
	public List<Comment> queryCommentsByGraIdAndUserId(int graId, int userId){
		List<Comment> commentList = commentMapper.queryCommentsByGraIdAndUserId(graId,userId);
		for (Comment comment : commentList) {
			comment.setUser(userMapper.getById(comment.getUserId()).get(0));
		}
		return commentList;
	}
}
