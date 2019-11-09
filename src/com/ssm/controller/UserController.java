package com.ssm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssm.model.User;
import com.ssm.service.UserService;

@Controller
@RequestMapping("/student")
public class UserController {

	@Resource
	private UserService userService;
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
    public String add(User user){
    	userService.add(user);
    	return "/index"; 
    }
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(User user){
		userService.update(user);
		return "/test"; 
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(User user){
		userService.delete(user);
		return "/test"; 
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getUserList(){
		List<User> users = userService.getUserList();
		for (User u : users) {
			System.out.println("ID=" + u.getId()+ ", userName=" +u.getUserName());
		}
		return "/index"; 
	}
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
    public String main(){
    	return "/introduce"; 
    }
}
