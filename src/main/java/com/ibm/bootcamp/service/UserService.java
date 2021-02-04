package com.ibm.bootcamp.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	public String greet(String name) {
		
		
		
		return "Hello!"+name;
		
		
	}

}
