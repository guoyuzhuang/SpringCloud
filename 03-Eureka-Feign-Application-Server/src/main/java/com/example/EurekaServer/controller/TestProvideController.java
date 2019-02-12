package com.example.EurekaServer.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EurekaServer.service.FirstFeignService;

@RestController
public class TestProvideController implements FirstFeignService {
	
	@Value("${service.name}")
	private String name;

	@GetMapping("/testProvide")
	public List<String> testProvide() {
		return Arrays.asList("1", "2", "3");
	}

	@Override
	public List<String> testFeign() {
		System.out.println("this name is " + name);
		return Arrays.asList("1", "2", "3", "3", "3", name);
	}
}
