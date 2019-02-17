package com.example.EurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@SpringBootApplication
public class EurekaTurbine {

	public static void main(String[] args) {
		SpringApplication.run(EurekaTurbine.class, args);
	}

}

