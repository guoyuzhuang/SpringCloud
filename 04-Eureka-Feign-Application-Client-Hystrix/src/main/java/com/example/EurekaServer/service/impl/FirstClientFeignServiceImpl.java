package com.example.EurekaServer.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.EurekaServer.pojo.FeignTestPOJO;
import com.example.EurekaServer.service.FirstClientFeignService;

@Component
public class FirstClientFeignServiceImpl implements FirstClientFeignService {

	@Override
	public List<String> testFeign() {
		return Arrays.asList("0", "this is testFeign forback method 这个是testFeign方法的托底数据");
	}

	@Override
	public FeignTestPOJO getById(Long id) {
		return null;
	}

	@Override
	public FeignTestPOJO getByIdWithPOST(Long id) {
		return null;
	}

	@Override
	public FeignTestPOJO add(Long id, String name) {
		return null;
	}

	@Override
	public FeignTestPOJO addWithGET(FeignTestPOJO pojo) {
		return null;
	}

	@Override
	public FeignTestPOJO addWithPOST(FeignTestPOJO pojo) {
		return null;
	}

}
