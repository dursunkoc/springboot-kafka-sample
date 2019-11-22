package com.aric.samples.springbootkafkasample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaOperations.OperationsCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author dursunkoc
 *
 */
@Service
public class ProducerService {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String topic, String message) {
		
		OperationsCallback<String, String, Boolean> callback = new OperationsCallback<String, String, Boolean>() {	
			@Override
			public Boolean doInOperations(KafkaOperations<String, String> operations) {
				operations.send(topic, message);
				return true;
			}
		};
		kafkaTemplate.executeInTransaction(callback);
		
		
	}
}
