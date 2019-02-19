package com.example.EurekaServer.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestProvideController {

	@GetMapping("/testProvide")
	public List<String> testProvide() {
		return Arrays.asList("1", "2", "3");
	}
}
