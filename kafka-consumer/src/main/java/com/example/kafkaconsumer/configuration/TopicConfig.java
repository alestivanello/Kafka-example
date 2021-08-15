package com.example.kafkaconsumer.configuration;

import java.util.HashMap;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class TopicConfig {

	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	@Value(value = "${kafka.topicName}")
	private String topic;

	@Bean
	public KafkaAdmin kafkaAdmin() {

		var configs = new HashMap<String, Object>();

		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);

		return new KafkaAdmin(configs);

	}

	@Bean

	public NewTopic topicDemo() {

		return new NewTopic(topic, 1, (short) 1);

	}

}
