package com.examtime.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examtime.models.User;
import com.examtime.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value ="/save",method = RequestMethod.POST,consumes =MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody User user){
		userService.save(user);
	}

}
