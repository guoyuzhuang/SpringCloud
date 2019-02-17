package com.example.EurekaServer.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.EurekaServer.pojo.FeignTestPOJO;
import com.example.EurekaServer.service.factory.FirstClientFeignServiceFactory;

//@FeignClient(name = "test-feign-application-service")
@FeignClient(name = "eureka-application-service", /*fallback = FirstClientFeignServiceImpl.class*/ fallbackFactory = FirstClientFeignServiceFactory.class)
public interface FirstClientFeignService/* extends FirstFeignService*/ {
	
	@RequestMapping(value = "/testFeign", method = RequestMethod.GET)
	public List<String> testFeign();
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	public FeignTestPOJO getById(@RequestParam(value="id") Long id);
	
	@RequestMapping(value="/get", method=RequestMethod.POST)
	public FeignTestPOJO getByIdWithPOST(@RequestBody Long id);
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public FeignTestPOJO add(@RequestParam("id") Long id, @RequestParam("name") String name);
	
	@RequestMapping(value="/addWithGET", method=RequestMethod.GET)
	public FeignTestPOJO addWithGET(@RequestBody FeignTestPOJO pojo);
	
	@RequestMapping(value="/addWithPOST", method=RequestMethod.POST)
	public FeignTestPOJO addWithPOST(@RequestBody FeignTestPOJO pojo);
}
