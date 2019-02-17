package com.example.EurekaServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.EurekaServer.pojo.FeignTestPOJO;
import com.example.EurekaServer.service.FirstClientFeignService;

@RestController
public class TestConsumeController {

	@Autowired
	private FirstClientFeignService service;

	@GetMapping("/testConsume")
	public List<String> testProvide() {
		List<String> result = service.testFeign();
		return result;
	}
	
	@GetMapping("/getById/{id}")
	public FeignTestPOJO getById(@PathVariable("id") Long id) {
		FeignTestPOJO feignTestPOJO = service.getById(id);
		return feignTestPOJO;
	}
	
	@GetMapping("/getByIdWithPOST")
	public FeignTestPOJO getByIdWithPOST(Long id) {
		FeignTestPOJO feignTestPOJO = service.getByIdWithPOST(id);
		return feignTestPOJO;
	}
	
	@GetMapping("/add")
	public FeignTestPOJO add(Long id) {
//		FeignTestPOJO feignTestPOJO = service.add(id, "this is add-get method");
		FeignTestPOJO feignTestPOJO = service.addWithGET(new FeignTestPOJO(id, "this is add-post method"));
		return feignTestPOJO;
	}
	
	@GetMapping("/addWithPOST")
	public FeignTestPOJO addWithPOST(Long id) {
		FeignTestPOJO feignTestPOJO = service.addWithPOST(new FeignTestPOJO(id, "this is addWithPOST"));
		return feignTestPOJO;
	}
}
