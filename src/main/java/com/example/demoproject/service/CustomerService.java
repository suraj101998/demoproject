package com.example.demoproject.service;

import java.util.List;

import com.example.demoproject.entity.Customers;

public interface CustomerService {
	
	public List<Customers> getAllCustomers();
	public Customers getCustomerById(int userId);
	public Customers addOrUpdateCustomer(Customers user);
	public Customers deleteCustomer(int userId) throws Exception;

}