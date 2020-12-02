package com.ibm.bootcamp.ms2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.ibm.bootcamp.ms2.config.ConfigBean;

import org.springframework.boot.ApplicationRunner;


@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
@SpringBootApplication
public class Bootcampms2Application {

	
	@Value("${spring.profiles.active}")
	private static String activeProfile;
	
//	@Autowired
//	static Environment environment;
//	
//	@Autowired
//	static ConfigBean configBean;
	
	private static final Logger log = LoggerFactory.getLogger(Bootcampms2Application.class);
	
	public static void main(String[] args) {
		
		//System.out.println("running with profile="+activeProfile);
		//System.out.println("running with profile using environment object ="+environment.getProperty("spring.profiles.active"));
		
		//System.out.println("running with configBean.getEnvironment="+configBean.getEnvironment());
		
		log.info("Logging ");
//		System.getenv().forEach((k, v) -> {
//		    System.out.println(k + ":" + v);
//		});
		SpringApplication.run(Bootcampms2Application.class, args);
		
		//System.out.println("running with profile="+activeProfile);
		
		
	}
	
//	@Bean
//    ApplicationRunner applicationRunner(Environment environment) {
//        return args -> {
//            log.info("message from application.properties " + environment.getProperty("message-from-application-properties"));
//        };
//    }

}
