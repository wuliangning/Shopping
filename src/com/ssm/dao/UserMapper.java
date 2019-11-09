package com.ssm.dao;

import java.util.List;

import com.ssm.model.User;



public interface UserMapper {
	
	public void add(User user);
	
	public void update(User user);
	
	public void delete(User user);
	
	public List<User> getUserList();
	
}
