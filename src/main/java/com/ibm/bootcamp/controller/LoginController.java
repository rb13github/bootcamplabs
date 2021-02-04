package com.ibm.bootcamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bootcamp.service.UserService;

@RequestMapping("api/greet")
@RestController
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@Value("${message}")
	private String message;
	
	
	@GetMapping("/{name}")
	public String greet(@PathVariable(value="name") String name) {
		
	return userService.greet(name);
	}
	
	@GetMapping("/message")
	public String msg() {
		
		System.out.println("welcome to BootCamp service");
		
		return this.message;
	}

}
