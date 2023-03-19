package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.Customer;
import com.example.entity.Product;
import com.example.repository.CustomerRepository;
import com.example.repository.ProductRepository;

//@EnableWebMvc
@SpringBootApplication
public class OnetomanyUnidirectionalApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(OnetomanyUnidirectionalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product p1 = Product.builder().pid(11).productName("tv").price(20000).qty(2).build();
		Product p2 = Product.builder().pid(12).productName("mob").price(10000).qty(4).build();
		List<Product> lp = new ArrayList<>();
		lp.add(p1);
		lp.add(p2);

		Customer c = new Customer();
		c.setName("a");
		c.setEmail("aaa");
		c.setGender("male");
		c.setProducts(lp);
		customerRepository.save(c);
		System.out.println("---------done-------------");

	}

}
