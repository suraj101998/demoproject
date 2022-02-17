package com.example.demoproject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoproject.service.CustomerService;

import com.example.demoproject.entity.Customers;


@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/allCustomers")
	public ResponseEntity<List<Customers>> getAllCustomers(){
		
		List<Customers> customers = null;
		
		try {
			customers = customerService.getAllCustomers();
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Customers> getUserById(@PathVariable("id") int userId){
		
		Customers customers = null;
		
		try {
			customers = customerService.getCustomerById(userId);
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}
	
	@PostMapping("/addorupdate") 
	public ResponseEntity<Customers> addOrUpdate(@RequestBody Customers user){
		
		Customers customers = null;
		
		try {
			customers = customerService.addOrUpdateCustomer(user);
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Customers> deleteUserById(@PathVariable("id") int userId){
		
		Customers customers = null;
		
		try {
			customers = customerService.deleteCustomer(userId);
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}
	

}