package com.ibm.bootcamp.ms2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.bootcamp.ms2.restclient.ConvertorFactorClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConvertCurrencyService {

	 @Autowired
	 ConvertorFactorClient convertorFactorClient;
	
	public ConvertCurrencyService()
	{
		
		System.out.println("in the default constructor ConvertCurrencyService() ");
		//this.convertorFactorClient=
	}
	
	
	@HystrixCommand(fallbackMethod = "defaultCurrencyConvertorFactor")
	public float convertCurrency(String country,float amount)
	
	{
		System.out.println("in the Service country="+country + "  amount="+amount);
		float conversionfactor=this.convertorFactorClient.getConversionFactor(country);
		
		return amount*conversionfactor;
	}
	
	private float defaultCurrencyConvertorFactor(String name,float amoount)
	
	{
		System.out.println("in the defaultCurrencyConvertorFactor"+  1.0);
		
		return (float) 1.0;
	}
}
