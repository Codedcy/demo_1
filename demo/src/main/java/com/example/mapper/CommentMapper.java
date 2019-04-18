package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.bean.Comment;

@Mapper
public interface CommentMapper {
	
	@Select("select * from comment order by commentTime desc")  
	public List<Comment> queryAllComments();
	
	@Select("select count(*) from comment")  
	public int getCounts();
	
	@Select("select count(*) from comment where graId=#{graId}")  
	public int getCountsByGraId(int graId);
	
	@Select("select * from comment order by commentTime desc limit #{start} , #{count}")  
	public List<Comment> queryAllCommentsPager(int start, int count);
	
	@Select("select graId from comment GROUP BY graId order by count(graId) desc limit 3")  
	public List<Integer> getMostPopularGra();
	
	@Select("select distinct graId from comment where userId = #{userId}")  
	public List<Integer> getGraIdByUserId(int userId);
	
	@Select("select * from comment where userId = #{userId} order by commentTime desc")  
	public List<Comment> queryCommentsByUserId(int userId);
	
	@Select("select * from comment where graId = #{graId} order by commentTime desc limit #{start} , #{count}")  
	public List<Comment> queryCommentsByGraId(int graId, int start, int count);
	
	@Select("select * from comment where userId = #{userId} and graId = #{graId} order by commentTime desc")  
	public List<Comment> queryCommentsByGraIdAndUserId(int graId, int userId);
	
	@Options(useGeneratedKeys=true,keyProperty="commentId")
    @Insert("insert into comment(userId,commentTime,commentText,graId,commetScole) values(#{userId},#{commentTime},#{commentText},#{graId},#{commetScole})")  
	public int addComment(Comment comment);
	
}
