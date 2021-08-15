package com.example.kafkaproducer.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
import com.example.kafkaproducer.dto.Message;
import com.example.kafkaproducer.serviceI.ProducerServiceI;

@RestController
@RequestMapping("message")
public class ProducerController {

	@Autowired
	ProducerServiceI producerService;

	@RequestMapping(value = "/send", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public void sendMessage(@RequestBody String msg) {

		System.out.print("el mensaje es: " + msg);
		var message = new Message();
		message.setMessage(msg);
		message.setTime(LocalDateTime.now());
		message.setId(UUID.randomUUID().toString());
		producerService.sendMessage(message);

	}
}
