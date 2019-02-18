package com.example.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderPublisher {
	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;

	//exchange 交换器名称
	@Value("${mq.config.exchange}")
	private String exchange;

	public void sendMessage(String message) {
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "", "info \t" + message);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "", "error \t" + message);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "", "warn \t" + message);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "", "debug \t" + message);
	}
}
