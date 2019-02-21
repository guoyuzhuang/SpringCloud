package com.example.EurekaServer.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestProvideController {
	
	private Logger logger = LoggerFactory.getLogger(TestProvideController.class);

	@GetMapping(value = "/testProvide", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> testProvide() {
		logger.info("服务端收到请求啦！");
		return Arrays.asList("1", "2", "3");
	}
}
