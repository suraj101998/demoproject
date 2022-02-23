package com.example.demoproject.dao;

import java.util.List;

import com.example.demoproject.response.UserDepartmentResponse;
public interface UserDao {

	public List<UserDepartmentResponse> getUserDepartment();
	public List<UserDepartmentResponse> getLatestTransactions();


}
