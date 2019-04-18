package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bean.User;
import com.example.mapper.UserMapper;

@Service
public class UserService {
	@Autowired
	public UserMapper userMapper;
	
	public User findByEmail(String email) {
		List<User> userList = userMapper.getByEmail(email);
		if(userList.size()>0) {
			return userList.get(0);
		}else {
			return null;
		}
	}
	
	public User getByUserId(int userId) {
		List<User> userList = userMapper.getById(userId);
		if(userList.size()>0) {
			return userList.get(0);
		}else {
			return null;
		}
	}
	
	public boolean add(User user) {
		if(userMapper.add(user) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean updateUser(User user) {
		if(userMapper.updateUser(user) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean updateUserWithoutHead(User user) {
		if(userMapper.updateUserWithoutHead(user) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public int updateUserPassWord(User user) {
		return userMapper.updateUserPassWord(user);
	}
}
