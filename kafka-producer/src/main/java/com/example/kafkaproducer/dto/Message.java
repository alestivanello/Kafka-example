package com.example.kafkaproducer.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Message {

	private String id;

	private String message;

	private LocalDateTime time;

}
