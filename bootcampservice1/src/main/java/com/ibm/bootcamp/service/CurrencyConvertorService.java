package com.ibm.bootcamp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.bootcamp.entity.CurrencyConvertor;
import com.ibm.bootcamp.repository.CurrencyConvertorRepository;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CurrencyConvertorService {
	
	//final TaxClient taxClient;
	
	@Autowired
	CurrencyConvertorRepository currencyConvertorRepo;
	
//	public CurrencyConvertorService(TaxClient taxClient) {
//		this.taxClient=taxClient;
//	}
//	
	public CurrencyConvertor createurrencyConvertor(CurrencyConvertor currencyConvertor) {
		
		
		
		
		return currencyConvertorRepo.save(currencyConvertor);
		
	}
	
	public Optional<CurrencyConvertor> geturrencyConvertor(String countryCode) {
		
		return currencyConvertorRepo.findById(countryCode);
	}
	
	public void deleteCurrencyConvertor(String countryCode)throws Exception {
		
		Optional<CurrencyConvertor> currencyConvertor=currencyConvertorRepo.findById(countryCode);
		if(currencyConvertor.isPresent()) {		
			currencyConvertorRepo.delete(currencyConvertor.get());
		}else {
			throw new Exception();
		}
		
	}

//@HystrixCommand(fallbackMethod="taxServiceFallback")
public Optional<CurrencyConvertor> getCurrencyConvertor(String id) {
		
 return currencyConvertorRepo.findById(id);
		
		
		
	}

//public ProductDTO taxServiceFallback(Long id) {
//	
//	Optional<Product> product= productRepo.findById(id);
//	
//	ProductDTO dto=null;
//	
//	if(product.isPresent()) {
//		
//	ProductConverter converter=new ProductConverter();
//		
//		dto=converter.convertToDTO(product.get());
//		
//		dto.setTax(5.0);
//	}
//	
//	return dto;
//	
//}
//	
	
	

}
