package com.ssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.UserMapper;
import com.ssm.model.User;

@Service
public class UserService {

	@Resource
	private UserMapper userMapper;
	
    public void add(User user){
    	userMapper.add(user);
    }
	
	public void update(User user){
		userMapper.update(user);
	}
	
	public void delete(User user){
		userMapper.delete(user);
	}
	
	public List<User> getUserList(){
		return userMapper.getUserList();
	}
}
