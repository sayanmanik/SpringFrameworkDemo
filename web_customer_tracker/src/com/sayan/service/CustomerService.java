package com.sayan.service;

import java.util.List;

import com.sayan.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
