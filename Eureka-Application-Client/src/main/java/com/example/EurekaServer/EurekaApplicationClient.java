package com.example.EurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplicationClient {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplicationClient.class, args);
	}

}

