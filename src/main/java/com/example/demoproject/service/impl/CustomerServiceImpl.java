package com.example.demoproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoproject.entity.Customers;
import com.example.demoproject.service.CustomerService;

import com.example.demoproject.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository userRepository;
	

	@Override
	public List<Customers> getAllCustomers() {
		// TODO Auto-generated method stub
		return (List<Customers>) userRepository.findAll();
	}

	@Override
	public Customers getCustomerById(int userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public Customers addOrUpdateCustomer(Customers user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Customers deleteCustomer(int userId) throws Exception {
		
		Customers deletedCustomer = null;
		try {
			deletedCustomer = userRepository.findById(userId).orElse(null);
			
			if(deletedCustomer == null) {
				throw new Exception("User is not available in database");
			}else {
				userRepository.deleteById(userId);
			}
		}catch(Exception ex) {
			throw ex;
		}
		return null;
	}


}
