package com.example.kafkaconsumer.serviceI;

import java.util.List;

import com.example.kafkaconsumer.dto.Message;

public interface ConsumerServiceI {

	public List<Message> getMessages();
	
}
