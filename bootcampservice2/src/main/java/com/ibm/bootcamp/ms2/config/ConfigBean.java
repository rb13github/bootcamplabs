package com.ibm.bootcamp.ms2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigBean {
	
	@Value("${appname}")
    private String appname;
	@Value("${environment}")
    private String environment;
	
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String toString()
	
	{
		return "{\"appname\":\""+appname+"\", \"environment\":\""+environment+"\"}";
	}

}
