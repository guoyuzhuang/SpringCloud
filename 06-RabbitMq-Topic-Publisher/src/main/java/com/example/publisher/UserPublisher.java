package com.example.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserPublisher {
	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;

	//exchange 交换器名称
	@Value("${mq.config.exchange}")
	private String exchange;

	public void sendMessage(String message) {
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "user.log.info", "info \t" + message);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "user.log.error", "error \t" + message);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "user.log.warn", "warn \t" + message);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "user.log.debug", "debug \t" + message);
	}
}
