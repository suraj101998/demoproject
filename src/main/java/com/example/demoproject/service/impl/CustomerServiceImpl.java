package com.example.demoproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demoproject.response.UserDepartmentResponse;
import com.example.demoproject.dao.UserDao;
import com.example.demoproject.entity.Customers;
import com.example.demoproject.entity.Transactions;
import com.example.demoproject.service.CustomerService;
import com.example.demoproject.repository.CustomerRepository;
import com.example.demoproject.repository.TransactionsRepository;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository userRepository;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private TransactionsRepository TransactionsRepository;
	

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
	public Customers addCustomer(Customers user) {
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
	
	@Override
	public List<Customers> getCustomerByIdentityType(String id_type) {
		// TODO Auto-generated method stub
		return userRepository.getCustomerByIdentityType(id_type);
	}
	
	@Override
	public List<UserDepartmentResponse> getUserDepartMent() {
		
		return userDao.getUserDepartment();
	}

	@Override
	public List<UserDepartmentResponse> getLatestTransactions() {
		// TODO Auto-generated method stub
		return userDao.getLatestTransactions();
	}

	@Override
	public List<Transactions> getCustomerByID(int customer_id) {
		// TODO Auto-generated method stub
		return TransactionsRepository.getCustomerByID(customer_id);
	}


	@Override
	public List<Transactions> getCheckBalance(int customer_id) {
		// TODO Auto-generated method stub
		return TransactionsRepository.getCheckBalance(customer_id);
	}

//	@Override
//	public Customers UpdateCustomer(Customers user){
//		Customers UpdateCustomers= null;
//		try {
//			UpdateCustomers = userRepository.findById(user).orElse(null);
//			if(UpdateCustomers == null) {
//				throw new Exception("User is not available in database");
//			}else {
//				UpdateCustomers.setCustomer_Id(UpdateCustomers.getCustomer_Id());
//				UpdateCustomers.setName(UpdateCustomers.getName());
//				UpdateCustomers.setAccount(UpdateCustomers.getAccount());
//				UpdateCustomers.setId_type(UpdateCustomers.getId_type());
//				UpdateCustomers.setId_num(UpdateCustomers.getId_num());
//				UpdateCustomers.setDob(UpdateCustomers.getDob());
//				UpdateCustomers.setPhone(UpdateCustomers.getPhone());
//				UpdateCustomers.setEmail(UpdateCustomers.getEmail());
//				UpdateCustomers.setAddress(UpdateCustomers.getAddress());
//				UpdateCustomers.setSex(UpdateCustomers.getSex());
//				
//				 userRepository.save(user);
//			}
//		}catch(Exception ex) {
//		
//	}
//		return null;
//	}

	@Override
	public List<Transactions> getTransactionByType(String transaction_type) {
		// TODO Auto-generated method stub
		return TransactionsRepository.getTransactionByType(transaction_type);
	}

	@Override
	public Customers UpdateCustomer(Customers user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public Transactions addTransactions(Transactions user) {
		// TODO Auto-generated method stub
		return TransactionsRepository.save(user);
	}

	@Override
	public Transactions UpdateTransactions(Transactions user) {
		// TODO Auto-generated method stub
		return TransactionsRepository.save(user);
	}
	
	
}
