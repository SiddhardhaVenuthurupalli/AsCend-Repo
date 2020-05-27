package com.ascend.spring.cd.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@RestController
@EnableCircuitBreaker
public class CircuitBreakerPcfApplication {
	@Autowired
	private RestTemplate template;
	
	
	@GetMapping("/")
	public String getAPIResponse() {
		return template.getForObject("http://dummy.restapiexample.com/api/v1/employees", String.class);
	}
	
	@GetMapping("/api")
	@HystrixCommand(fallbackMethod="APIFallBack")
	public String getFailureAPI() {
		return template.getForObject("http://nourlfound.com", String.class);
	}
	
	
	private String APIFallBack() {
		return "API is not working, try again later...";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerPcfApplication.class, args);
	}
	
	@Bean
	public RestTemplate getTeamplate() {
		return new RestTemplate();
	}

}
