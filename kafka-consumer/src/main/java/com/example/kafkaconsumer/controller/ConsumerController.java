package com.example.kafkaconsumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaconsumer.dto.Message;
import com.example.kafkaconsumer.serviceI.ConsumerServiceI;

@RestController
@RequestMapping("message")
public class ConsumerController {

	@Autowired
	ConsumerServiceI service;

	@RequestMapping(value = "/getMessages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Message>> sendMessage() {
		var msgs = this.service.getMessages();
		System.out.println("aca: " + msgs.size());
		return ResponseEntity.ok(msgs);
	}
}
