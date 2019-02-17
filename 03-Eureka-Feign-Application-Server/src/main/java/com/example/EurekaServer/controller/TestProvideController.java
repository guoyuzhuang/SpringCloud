package com.example.EurekaServer.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EurekaServer.pojo.FeignTestPOJO;
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

	@Override
	public FeignTestPOJO getById(Long id) {
		System.out.println("this method is getById");
		return new FeignTestPOJO(id, "this is getById method");
	}

	@Override
	public FeignTestPOJO getByIdWithPOST(@RequestBody Long id) {
		System.out.println("this method is getByIdWithPOST");
		return new FeignTestPOJO(id, "this method is getByIdWithPOST");
	}

	@Override
	public FeignTestPOJO add(Long id, String name) {
		System.out.println("this method is add 1");
		return new FeignTestPOJO(id, name);
	}

	@Override
	public FeignTestPOJO addWithGET(@RequestBody FeignTestPOJO pojo) {
		System.out.println("this method is add pojo");
		return pojo;
	}

	@Override
	public FeignTestPOJO addWithPOST(@RequestBody FeignTestPOJO pojo) {
		System.out.println("this method is addWithPOST");
		return pojo;
	}
}
