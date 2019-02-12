package com.example.EurekaServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestConsumeController {

	/**
	 * ribbon负载均衡器，其中记录了从Eureka Server中获取的所有服务信息。 
	 * 这些服务的信息是IP和端口等。应用名称，域名，主机名等信息。
	 */
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/testConsume")
	public List<String> testProvide() {
		// 通过spring应用命名，获取服务实例ServiceInstance对象
		// ServiceInstance 封装了服务的基本信息，如 IP，端口
		/*
		 * 在Eureka中，对所有注册到Eureka Server中的服务都称为一个service instance服务实例。
		 * 一个服务实例，就是一个有效的，可用的，provider单体实例或集群实例。
		 * 每个service instance都和spring application name对应。
		 * 可以通过spring application name查询service instance
		 */
		ServiceInstance si = this.loadBalancerClient.choose("eureka-application-service");
		// 拼接访问服务的URL
		StringBuilder sb = new StringBuilder();
		// http://localhost:8081/test
		sb.append("http://").append(si.getHost()).append(":").append(si.getPort()).append("/testProvide");

		System.out.println("本次访问的service是： " + sb.toString());

		// SpringMVC RestTemplate，用于快速发起REST请求的模板对象。
		/*
		 * RestTemplate是SpringMVC提供的一个用于发起REST请求的模板对象。
		 * 基于HTTP协议发起请求的。
		 * 发起请求的方式是exchange。需要的参数是： URL, 请求方式， 请求头， 响应类型，【URL rest参数】。
		 */
		RestTemplate rt = new RestTemplate();

		/*
		 * 创建一个响应类型模板。
		 * 就是REST请求的响应体中的数据类型。
		 * ParameterizedTypeReference - 代表REST请求的响应体中的数据类型。
		 */
		ParameterizedTypeReference<List<String>> type = new ParameterizedTypeReference<List<String>>() {
		};

		/*
		 * ResponseEntity:封装了返回值信息，相当于是HTTP Response中的响应体。
		 * 发起REST请求。
		 */
		ResponseEntity<List<String>> response = rt.exchange(sb.toString(), HttpMethod.GET, null, type);
		/*
		 * ResponseEntity.getBody() - 就是获取响应体中的java对象或返回数据结果。
		 */
		List<String> result = response.getBody();

		return result;
	}
}
