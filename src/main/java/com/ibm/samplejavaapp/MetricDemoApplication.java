package com.ibm.samplejavaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class MetricDemoApplication {
	@GetMapping("/messages")
	public String getMessage() {
		return "Hello from Docker!";
	}


	public static void main(String[] args) {
		SpringApplication.run(MetricDemoApplication.class, args);
	}

}
