package com.sayan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sayan.dao.CustomerDAO;
import com.sayan.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private CustomerDAO customerDAO;
	
	@GetMapping("/list")
	public String listCustomers(Model model){
		
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		model.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
}
