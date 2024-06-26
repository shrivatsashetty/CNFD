package com.example.LabCycle07;

//CustomerService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	// CREATE
	public void addCustomer(String fname, String lname) {
		Customer customer = new Customer();
		customer.setFirstName(fname);
		customer.setLastName(lname);
		customerRepository.save(customer);
	}

	// READ
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	// UPDATE
	public void updateCustomer(long id, String fname, String lname) {
		Customer customer = customerRepository.findById(id).orElse(null);
		if (customer != null) {
			customer.setFirstName(fname);
			customer.setLastName(lname);
			customerRepository.save(customer);
		}
	}

	// DELETE
	public void deleteCustomer(long id) {
		customerRepository.deleteById(id);
	}

}