package com.ibm.bootcamp.ms2.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name ="manage-conversionfactor-ms", url = "http://localhost:8080/")
@FeignClient("manage-conversionfactor-ms")
public interface ConvertorFactorClient {

	@GetMapping("currency-convertor/conversionfactor/{countryCode}")
	public float getConversionFactor(@PathVariable(value="countryCode") String name);
	
}
