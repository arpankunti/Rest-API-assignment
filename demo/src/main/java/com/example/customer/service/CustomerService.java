package com.example.customer.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.customer.entity.Customer;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	public Customer saveCustomer(Customer customer) {	
			return repo.save(customer);
	}

	public List<Customer> getAllCustomer() {
		List<Customer> customers = repo.findAll();
		if(customers.size()!=0) {
		return customers;
		}
		else {
			throw new CustomerNotFoundException("no customer is there");
		}
	}

	public Customer getCustomerById(int id) throws CustomerNotFoundException {
		Customer customer = repo.findByCustomerId(id);
		if (customer!=null) {
			return customer;
		}else {
			throw new CustomerNotFoundException("customer not found with id "+ id);
		}
	}

	public List<Customer> getCustomerByFirstName(String firstName) {
		List<Customer> customers= repo.findByFirstName(firstName);
		if (customers.size()!=0) {
			return customers;
		}else {
			throw new CustomerNotFoundException("customer not found with firstName "+ firstName);
		}
	}

	public String deleteCustomer(int id) {
		Customer customer = getCustomerById(id);
		if (customer!=null) {
			repo.deleteById(id);
			return "deleted customer with id " + id;
		}
		else {
			throw new CustomerNotFoundException("customer not found with id "+ id);
		}
			
		
	}

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		

			Customer existingCustomer = getCustomerById(customer.getCustomerId());
			if (existingCustomer!=null) {
			existingCustomer.setFirstName(customer.getFirstName());
			existingCustomer.setLastName(customer.getLastName());
			existingCustomer.setAddress(customer.getAddress());
			existingCustomer.setPhoneNumber(customer.getPhoneNumber());

			return repo.save(existingCustomer);
			}
			else {
				throw new CustomerNotFoundException("customer not found with id "+ customer.getCustomerId());
			}
			
	

	}

}
