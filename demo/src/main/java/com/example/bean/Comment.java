package com.example.bean;

import java.sql.Date;

public class Comment {
	private int commentId;
	private int userId;
	private String commentTime;
	private String commentText;
	private int graId;
	private User user;
	private Gra gra;
	private float commetScole;
	
	
	
	
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", userId=" + userId + ", commentTime=" + commentTime
				+ ", commentText=" + commentText + ", graId=" + graId + ", user=" + user + ", gra=" + gra
				+ ", commetScole=" + commetScole + ", getCommetScole()=" + getCommetScole() + ", getGra()=" + getGra()
				+ ", getUser()=" + getUser() + ", getGraId()=" + getGraId() + ", getCommentId()=" + getCommentId()
				+ ", getUserId()=" + getUserId() + ", getCommentTime()=" + getCommentTime() + ", getCommentText()="
				+ getCommentText() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public float getCommetScole() {
		return commetScole;
	}
	public void setCommetScole(float commetScole) {
		this.commetScole = commetScole;
	}
	public Gra getGra() {
		return gra;
	}
	public void setGra(Gra gra) {
		this.gra = gra;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getGraId() {
		return graId;
	}
	public void setGraId(int graId) {
		this.graId = graId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	
	
	
}
