package com.example.kafkaconsumer.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafkaconsumer.dto.Message;
import com.example.kafkaconsumer.serviceI.ConsumerServiceI;

@Service
public class ConsumerServiceImp implements ConsumerServiceI {

	private List<Message> mensajes = new ArrayList<Message>();

	@KafkaListener(topics = "${kafka.topicName}", groupId = "demo")
	public void listenGroupDemo(Message message) {

		System.out.println("llegó " + message.getMessage());

		var received = new Message();
		received.setId(message.getId());
		received.setMessage(message.getMessage());
		received.setTime(message.getTime());

		this.mensajes.add(received);
		System.out.println("tengo " + mensajes.size());
	}

	public List<Message> getMessages() {
		List<Message> retorno = new ArrayList<Message>();
		retorno.addAll(this.mensajes);
		this.mensajes.clear();
		return retorno;
	}
}
