package com.example;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=RabbitMqPublisher.class)
public class TestDirectSend {
	@Autowired
	private DirectSericeImpl directSericeImpl;

	@Test
	public void test() {
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("开始发送消息");
			directSericeImpl.sendMessage("测试项");
			System.out.println("消息发送成功----------------");
		}
	}
}
