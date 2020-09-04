package com.sayan.dao;

import java.util.List;

import com.sayan.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
