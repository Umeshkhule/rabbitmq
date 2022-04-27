package com.vasyerp.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vasyerp.configuration.RabbitMQConfigure;
import com.vasyerp.model.User;

@RestController
public class UserPublisher {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostMapping("/publish")
	public String publish(@RequestBody User user) {
		rabbitTemplate.convertAndSend(RabbitMQConfigure.EXCHANGE,RabbitMQConfigure.ROUTING_KEY,user);
		return "Publish successfully!!";
	}

}
