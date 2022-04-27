package com.vasyerp.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.vasyerp.model.User;

@Component
public class UserConsumer{
	@RabbitListener(queues="user_queue")
	public void consumeUser(User user) {
		System.out.println("Message Recieved From Queue :"+user);
	}
}
