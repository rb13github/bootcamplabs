package com.ibm.bootcamp.ms2.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.bootcamp.ms2.config.ConfigBean;
import com.ibm.bootcamp.ms2.service.ConvertCurrencyService;




//import io.swagger.annotations.ApiOperation;


//import io.swagger.annotations.ApiOperation;



@RequestMapping("convert-currency-ms")
@RestController
public class ConvertCurrencyController {
	
	Logger logger=LoggerFactory.getLogger(ConvertCurrencyController.class);

	@Autowired
	ConvertCurrencyService convertCurrencyService;
	
	@Autowired
	ConfigBean configBean;
	
	@GetMapping("/checkavailabity")
	public String message() {
		return "hello-convert-currency-ms";
	}
	
	@GetMapping("/property")
	public String getProperty() {
		
		
		return configBean.toString();
	}
	
	//@ApiOperation("This api will the return the amount  after converstion for the given country code & amount")
	@GetMapping("/country/{countryCode}/amount/{amount}") //localhost:8080/convert-currency-ms/
	public float getConversionAmount(@PathVariable(value="countryCode")String countryCode,@PathVariable(value="amount")float amount) {
		
		System.out.println("in the controller country="+countryCode + "  amount="+amount);
		return convertCurrencyService.convertCurrency(countryCode,amount);
		
		
	}
	
	
	
}


