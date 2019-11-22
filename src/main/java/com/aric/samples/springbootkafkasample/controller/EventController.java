/**
 * 
 */
package com.aric.samples.springbootkafkasample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aric.samples.springbootkafkasample.model.Customer;
import com.aric.samples.springbootkafkasample.model.Customers;
import com.aric.samples.springbootkafkasample.service.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author dursunkoc
 *
 */
@RestController
@RequestMapping("event")
@Slf4j
public class EventController {
	public static final String CUSTOMER_CRT = "customer.create";

	private static final ObjectMapper OM = new ObjectMapper();
	
	@Autowired
	private ProducerService producerService;

	private void customerCreated(Customer customer) throws JsonProcessingException {
		producerService.sendMessage(CUSTOMER_CRT, OM.writeValueAsString(customer));
		log.trace("customer event: {}", customer);
	}

	@PostMapping
	public ResponseEntity<String> customersCreated(@RequestBody Customers customers) throws JsonProcessingException {
		customers.getItems().forEach(c->{
			try {
				customerCreated(c);
			} catch (JsonProcessingException e) {
			}
		});
		return ResponseEntity.ok("OK");
	}
}
