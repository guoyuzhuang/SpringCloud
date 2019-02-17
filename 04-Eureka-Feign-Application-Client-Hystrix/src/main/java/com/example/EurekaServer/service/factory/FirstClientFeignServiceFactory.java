package com.example.EurekaServer.service.factory;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.EurekaServer.pojo.FeignTestPOJO;
import com.example.EurekaServer.service.FirstClientFeignService;

import feign.hystrix.FallbackFactory;

@Component
public class FirstClientFeignServiceFactory implements FallbackFactory<FirstClientFeignService> {

	@Override
	public FirstClientFeignService create(Throwable cause) {
		return new FirstClientFeignService() {
			
			@Override
			public List<String> testFeign() {
				return Arrays.asList("0", "this is testFeign forback method 这个是testFeign方法的托底数据，使用fallbackfactory执行结果");
			}
			
			@Override
			public FeignTestPOJO getByIdWithPOST(Long id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public FeignTestPOJO getById(Long id) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public FeignTestPOJO addWithPOST(FeignTestPOJO pojo) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public FeignTestPOJO addWithGET(FeignTestPOJO pojo) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public FeignTestPOJO add(Long id, String name) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

}
