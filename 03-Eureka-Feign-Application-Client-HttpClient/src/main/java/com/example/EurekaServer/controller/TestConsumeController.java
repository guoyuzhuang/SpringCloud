package com.example.EurekaServer.controller;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EurekaServer.service.FirstClientFeignService;

@RestController
public class TestConsumeController {
	
	@Autowired
	private HttpClient httpClient;

	@Autowired
	private FirstClientFeignService service;

	@GetMapping("/testConsume")
	public List<String> testProvide() {
		System.out.println(httpClient);
		List<String> result = service.testFeign();
		return result;
	}
}
