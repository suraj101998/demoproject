package com.example.demoproject.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoproject.service.CustomerService;
import com.example.demoproject.response.UserDepartmentResponse;
import com.example.demoproject.entity.Customers;
import com.example.demoproject.entity.Transactions;


@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/DisplayAllCutomers")
	public ResponseEntity<List<Customers>> getAllCustomers(){
		
		List<Customers> customers = null;
		
		try {
			customers = customerService.getAllCustomers();
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/FindByCustomerID/{id}")
	public ResponseEntity<Customers> getUserById(@PathVariable("id") int userId){
		
		Customers customers = null;
		
		try {
			customers = customerService.getCustomerById(userId);
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}
	
	@PostMapping("/AddCustomers") 
	public ResponseEntity<Customers> addCustomer(@RequestBody Customers user){
		
		Customers customers = null;
		
		try {
			customers = customerService.addCustomer(user);
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}
	
	@PutMapping("/UpdateCustomer") 
	public ResponseEntity<Customers> UpdateCustomer(@RequestBody Customers user){
		
		Customers customers = null;
		
		try {
			customers = customerService.addCustomer(user);
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}
	
	@DeleteMapping("/DeleteCustomer/{id}")
	public ResponseEntity<Customers> deleteUserById(@PathVariable("id") int userId){
		
		Customers customers = null;
		
		try {
			customers = customerService.deleteCustomer(userId);
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/FilterCustomersByIDPoof/{id_type}")
	public ResponseEntity<List<Customers>> getCustomerByIdentityType(@PathVariable String id_type){
		
		List<Customers> customers = null;
		
		try {
			customers = customerService.getCustomerByIdentityType(id_type);
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/AllTransactionsHistory")
	public ResponseEntity<List<UserDepartmentResponse>> getAllUserDepartments(){
		
		List<UserDepartmentResponse> transactions = null;
		
		try {
			transactions = customerService.getUserDepartMent();
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<List<UserDepartmentResponse>>(transactions, HttpStatus.OK);
	}
	
	@GetMapping("/LatestTransactions")
	public ResponseEntity<List<UserDepartmentResponse>> getLatestTransactions(){
		
		List<UserDepartmentResponse> transactions = null;
		
		try {
			transactions = customerService.getLatestTransactions();
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		
		return new ResponseEntity<List<UserDepartmentResponse>>(transactions, HttpStatus.OK);
	}
	
	@GetMapping("/Ministatement/{id}")
	public ResponseEntity<List<Transactions>> getCustomerByID(@PathVariable("id") int customer_id){
		
		List<Transactions> transactions = null;
		
		try {
			transactions = customerService.getCustomerByID(customer_id);
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<Transactions>>(transactions, HttpStatus.OK);
	}
	
	
	@GetMapping("/CheckBalance/{id}")
	public ResponseEntity<List<Transactions>> getCheckBalance(@PathVariable("id") int customer_id){
		
		List<Transactions> transactions = null;
		
		try {
			transactions = customerService.getCheckBalance(customer_id);
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<Transactions>>(transactions, HttpStatus.OK);
	}
	
	@GetMapping("/CheckTransactionType/{type}")
	public ResponseEntity<List<Transactions>> getTransactionByType(@PathVariable("type") String transaction_type){
		
		List<Transactions> transactions = null;
		
		try {
			transactions = customerService.getTransactionByType(transaction_type);
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<Transactions>>(transactions, HttpStatus.OK);
	}
	
	
}