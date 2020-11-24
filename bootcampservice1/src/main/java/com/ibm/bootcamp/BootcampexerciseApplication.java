package com.ibm.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BootcampexerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampexerciseApplication.class, args);
	}

}
