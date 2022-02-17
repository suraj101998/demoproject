package com.example.demoproject.repository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.demoproject.entity.Customers;

@Repository
public interface CustomerRepository extends CrudRepository<Customers, Integer> {

	
}