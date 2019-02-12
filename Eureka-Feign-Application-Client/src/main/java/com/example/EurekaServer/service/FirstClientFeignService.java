package com.example.EurekaServer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

//@FeignClient(name = "test-feign-application-service")
@FeignClient(name = "eureka-application-service")
public interface FirstClientFeignService extends FirstFeignService {

}
