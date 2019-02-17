package com.example.EurekaServer;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ThreadPoolTest {

	public static void main(String[] args) {
		ExecutorService executorList = Executors.newFixedThreadPool(9);
		for (int i = 0; i < 10000; ++i) {
			executorList.execute(new Runnable() {

				@Override
				public void run() {
					
					RestTemplate rt = new RestTemplate();
					ParameterizedTypeReference<List<String>> type = new ParameterizedTypeReference<List<String>>() {
					};
					ResponseEntity<List<String>> response = rt.exchange("http://luokeke:9001/testConsume", HttpMethod.GET, null, type);
					List<String> result = response.getBody();
					System.out.println("请求完成");
				}
			});
		}
	}

}
