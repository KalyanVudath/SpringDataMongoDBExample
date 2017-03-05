package com.example.mongoDB;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;
	public static void main(String[] args) {		
		SpringApplication.run(SampleApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		this.repository.deleteAll();
		
		// Insert Users
		this.repository.save(new Customer("Kalyan","Vudathu"));
		this.repository.save(new Customer("Kalyan12","Vudathu23"));
		
		
		// Fetch All users
		List<Customer> custList = this.repository.findAll();
		
		for(Customer cust: custList)
			System.out.println(cust.toString());
		
		System.out.println("Customer found with findByFirstName('Kalyan'):");
		System.out.println("--------------------------------");
		System.out.println(this.repository.findByFirstName("Kalyan"));
	}
}
