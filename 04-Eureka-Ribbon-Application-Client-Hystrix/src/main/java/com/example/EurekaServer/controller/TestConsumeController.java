package com.example.EurekaServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EurekaServer.service.RibbonHystorixService;

@RestController
public class TestConsumeController {

	/**
	 * ribbon负载均衡器，其中记录了从Eureka Server中获取的所有服务信息。 
	 * 这些服务的信息是IP和端口等。应用名称，域名，主机名等信息。
	 */
	@Autowired
	private RibbonHystorixService ribbonHystorixService;

	//服务降级测试
	@GetMapping("/testDowngrade")
	public List<String> testDowngrade() {
		return ribbonHystorixService.testDowngrade();
	}
}
