/**
 * 
 */
package com.aric.samples.springbootkafkasample.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.aric.samples.springbootkafkasample.controller.EventController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dursunkoc
 *
 */
@Service
@Slf4j
public class CustomerCreationPostActions {
	
	@KafkaListener(topics = EventController.CUSTOMER_CRT, groupId = "customerActivation")
	public void customerCreateEventConsumer(String customer) {
		log.info("customer activated: {}", customer);
	}
	
}
