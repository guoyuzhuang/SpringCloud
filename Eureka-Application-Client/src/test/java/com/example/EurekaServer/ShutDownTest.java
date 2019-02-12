package com.example.EurekaServer;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ShutDownTest {

	@Test
	public void shutdown() {
		String url = "http://luokeke:8000/shutdown";
		RestTemplate rt = new RestTemplate();
		ParameterizedTypeReference<Object> type = new ParameterizedTypeReference<Object>() {
		};
		ResponseEntity<Object> response = rt.exchange(url, HttpMethod.POST, null, type);
		Object result = response.getBody();
		System.out.println("打印执行结果：" + result);
	}

}
