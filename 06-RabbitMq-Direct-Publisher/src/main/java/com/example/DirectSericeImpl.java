package com.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DirectSericeImpl {
	
	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;
	
	//exchange 交换器名称
	@Value("${mq.config.exchange}")
	private String exchange;
	
	//routingkey 路由键
	@Value("${mq.config.queue.error.routing.key}")
	private String routingkey;

	public List<String> sendMessage(String name) {
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, this.routingkey, name);
		return Arrays.asList("success");
	}
}
