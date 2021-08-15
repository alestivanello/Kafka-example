package com.example.kafkaconsumer.configuration;

import java.util.HashMap;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import com.example.kafkaconsumer.dto.Message;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	@Bean
	public ConsumerFactory<String, Message> consumerFactory() {

	    JsonDeserializer<Message> deserializer = new JsonDeserializer<>(Message.class);
	    deserializer.setRemoveTypeHeaders(false);
	    deserializer.addTrustedPackages("*");
	    deserializer.setUseTypeMapperForKey(true);
	    
		var props = new HashMap<String, Object>();

		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);

		props.put(ConsumerConfig.GROUP_ID_CONFIG, "demo");

		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);

	    return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Message> kafkaListenerContainerFactory() {

		var factory = new ConcurrentKafkaListenerContainerFactory<String, Message>();

		factory.setConsumerFactory(this.consumerFactory());

		return factory;

	}
}
