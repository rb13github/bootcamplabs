package com.ibm.bootcamp.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/web")
@Controller
public class WebController {

	@GetMapping({"/", "/index"})

	  //public String index(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {

	public String index() {
	
		System.out.println(" in the web/index ");
		
	        return "/login.jsp";


	    }


    
}