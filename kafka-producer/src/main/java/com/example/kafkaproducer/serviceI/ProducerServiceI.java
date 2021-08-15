package com.example.kafkaproducer.serviceI;

import com.example.kafkaproducer.dto.Message;

public interface ProducerServiceI {

	public void sendMessage(Message message);
}
