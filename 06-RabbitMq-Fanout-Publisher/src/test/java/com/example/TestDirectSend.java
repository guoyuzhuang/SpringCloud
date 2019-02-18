package com.example;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.publisher.OrderPublisher;
import com.example.publisher.UserPublisher;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMqPublisher.class)
public class TestDirectSend {

	@Autowired
	private OrderPublisher orderPublisher;

	@Autowired
	private UserPublisher userPublisher;

	@Test
	public void test() {
		while (true) {
			System.out.println("开始发送消息");
			orderPublisher.sendMessage("订单日志信息");
			userPublisher.sendMessage("用户日志信息");
			System.out.println("消息发送成功----------------");
			try {
				TimeUnit.SECONDS.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
