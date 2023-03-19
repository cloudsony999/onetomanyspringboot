package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.OrderRequest;
import com.example.dto.OrderResponse;
import com.example.entity.Customer;
import com.example.repository.CustomerRepository;
import com.example.repository.ProductRepository;

@RestController
public class OrderController {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/order")
	public Customer placeOrder(@RequestBody OrderRequest request) {
		return customerRepository.save(request.getCustomer());
	}

	@GetMapping("/order")
	public List<Customer> findAllOrders() {
		return customerRepository.findAll();
	}

	@GetMapping("/getInfo")
	public List<OrderResponse> getJoinInformation() {
		return customerRepository.getJoinInformation();
	}
}