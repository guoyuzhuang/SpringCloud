package com.example.EurekaServer.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface FirstFeignService {
	
	@RequestMapping(value = "/testFeign", method = RequestMethod.GET)
	public List<String> testFeign();
}
