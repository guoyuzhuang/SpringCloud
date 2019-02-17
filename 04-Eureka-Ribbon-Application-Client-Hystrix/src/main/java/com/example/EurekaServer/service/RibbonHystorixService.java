package com.example.EurekaServer.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RibbonHystorixService {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@HystrixCommand(fallbackMethod = "downgradeFallback")
	public List<String> testDowngrade() {
		ServiceInstance si = this.loadBalancerClient.choose("eureka-application-service");
		StringBuilder sb = new StringBuilder();
		sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/testProvide");
		System.out.println("本次访问的service是： " + sb.toString());
		RestTemplate rt = new RestTemplate();
		ParameterizedTypeReference<List<String>> type = new ParameterizedTypeReference<List<String>>() {
		};
		ResponseEntity<List<String>> response = rt.exchange(sb.toString(), HttpMethod.GET, null, type);
		List<String> result = response.getBody();
		return result;
	}
	
	private List<String> downgradeFallback() {
		return Arrays.asList("this method is 服务降级测试方法返回托底数据");
	}
}
