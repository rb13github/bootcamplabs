package com.ibm.bootcamp.controller;

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
import com.ibm.bootcamp.entity.CurrencyConvertor;
import com.ibm.bootcamp.service.CurrencyConvertorService;

import io.swagger.annotations.ApiOperation;



@RequestMapping("currency-convertor")
@RestController
public class CurrencyConvertorController {
	
	Logger logger=LoggerFactory.getLogger(CurrencyConvertorController.class);

	@Autowired
	CurrencyConvertorService currencyConvertorService;
	
	@GetMapping("/checkavailabity")
	public String message() {
		return "hello-currency-convertor";
	}
	
	@PostMapping("/")
	@ApiOperation("This will create conversionfactor entity")
	public ResponseEntity<CurrencyConvertor> create(@RequestBody CurrencyConvertor currencyConvertor) {
		
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(currencyConvertorService.createurrencyConvertor(currencyConvertor));
	}
	
	@ApiOperation("This return the product for given country code")
	@GetMapping("/") //localhost:8080/product?id=1
	public ResponseEntity<CurrencyConvertor> getCurrencyConvertor(@RequestParam(value="countryCode")String countryCode) {
		
		Optional<CurrencyConvertor> currencyConvertor= currencyConvertorService.getCurrencyConvertor(countryCode);
		
		if(currencyConvertor.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.OK).body(currencyConvertor.get());
		}else {
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		
		
	}
	
	@GetMapping("/{countryCode}") //localhost:8085/product/1
	public ResponseEntity<CurrencyConvertor> getCurrencyConvertorFromPath(@PathVariable(value="countryCode")String countryCode) {
		
Optional<CurrencyConvertor> currencyConvertor= currencyConvertorService.getCurrencyConvertor(countryCode);
		
		if(currencyConvertor.isPresent()) {
			
			return ResponseEntity.status(HttpStatus.OK).body(currencyConvertor.get());
		}else {
			
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		
	}
	
	@DeleteMapping("/{countryCode}")
	public ResponseEntity<CurrencyConvertor> deleteCurrencyConvertor(@PathVariable(value="countryCode")String countryCode) {
		try {
		currencyConvertorService.deleteCurrencyConvertor(countryCode);
		}catch(Exception ex1) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
}


